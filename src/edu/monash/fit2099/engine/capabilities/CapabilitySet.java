package edu.monash.fit2099.engine.capabilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A collection of Capability objects.
 * The original purpose of Capabilities was to allow game clients to check whether Actors could do particular Actions,
 * whether Items provided (or required) certain abilities, whether terrain was passable under particular
 * circumstances, etc.  Consider Capabilities an all-purpose mechanism for enabling game capabilities, statuses, etc.
 * Don't be too literal about the name. You can keep all sorts of things in here.
 * PURPLE, FLAT, HOUSE_RAVENCLAW, TEAM_HERBIVORE, etc.
 * Any Enum type can be used to represent a Capability, so these classes can and should be defined in the game client.
 */
public class CapabilitySet implements Capable {
	/**
	 * The set of capability (uniques only)
	 */
	private final Set<Enum<?>> capabilitySet = new HashSet<>();

	/**
	 * Checks whether the current set has the input capability
	 *
	 * @param capability the capability to be checked against the set
	 * @return boolean, whether the capability is found in the set
	 */
	public boolean hasCapability(Enum<?> capability) {
		return capabilitySet.contains(capability);
	}

	/**
	 * Adds a capability to the current set
	 *
	 * @param capability the capability to be added to the set
	 */
	public void addCapability(Enum<?> capability) {
		if(!hasCapability(capability)){
			capabilitySet.add(capability);
		}
	}

	/**
	 * Removes a capability from the current set
	 *
	 * @param capability the capability to be removed from the set
	 */
	public void removeCapability(Enum<?> capability) {
		if(hasCapability(capability)){
			capabilitySet.remove(capability);
		}
	}

	/**
	 * Converts the current set to a List
	 *
	 * @return an unmodifiable list of capabilities found in the current set
	 */
	public List<Enum<?>> capabilitiesList(){
		return List.copyOf(capabilitySet);
	}

	/**
	 * Returns a list of capabilities with a specific type, e.g. we can search for capabilities with type Status
	 *
	 * @param enumType the type of the capabilities that we want to search for, e.g. Status.class
	 * @return a list of capabilities with the input type
	 */
	@SuppressWarnings("unchecked")
	public <T extends Enum<?>> List<T> findCapabilitiesByType(Class<T> enumType){
		return capabilitySet.stream()
				.filter(c -> c.getDeclaringClass().equals(enumType))
				.map(response -> (T) response)
				.collect(Collectors.toList());
	}
}
