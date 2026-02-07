package polymorphism;

public class PDFDocument extends  Document{

    @Override
    public PDFDocument duplicate(){
        System.out.println("pdf duplicated");
        return null;
    }
}
