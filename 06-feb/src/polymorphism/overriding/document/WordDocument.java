package polymorphism.overriding.document;

public class WordDocument extends Document{
    public WordDocument duplicate(){
        System.out.println("duplicate word");
        return new WordDocument();
    }
}
