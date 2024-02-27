import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileNotFoundException
import java.io.IOException

fun main() {
    try {
        val writer = com.itextpdf.kernel.pdf.PdfWriter("src/main/resources/hello.pdf")
        val pdf = com.itextpdf.kernel.pdf.PdfDocument(writer)
        pdf.addNewPage()
        val document = com.itextpdf.layout.Document(pdf)
        val paragraph = com.itextpdf.layout.element.Paragraph("List of Countries")
        document.add(paragraph)
        




        document.close()


    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}