package polymorphism;

public class Document {

    public Document duplicate(){
        System.out.println("Document duplicated");
        return new Document();
    }
}
