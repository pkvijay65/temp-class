package interfaces;

/**
 * Marker Interface - no methods, just a "tag" or "marker".
 * Used to indicate that a class has a certain property/capability.
 */
public interface Deletable {
    // No methods - this is a marker interface
    // Classes implementing this are marked as "safe to delete"

    void delete();

    default void print(){
        System.out.println("This is a deletable");
    }

}
