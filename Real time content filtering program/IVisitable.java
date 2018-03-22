/**
 * interfata care se ocupa de a accepta obiectul de tip visitor
 */
public interface IVisitable {

    boolean accept (IVisitor visitor,FeedStruct f);
}
