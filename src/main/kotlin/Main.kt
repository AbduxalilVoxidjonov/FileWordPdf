package org.example

import Package1Item
import com.google.gson.Gson
import org.apache.poi.xwpf.usermodel.ParagraphAlignment
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import java.io.*


fun main() {
    try {
        val gson = Gson()
        val sourceFile = File("src/main/resources/package.json")
        val reader = BufferedReader(FileReader(sourceFile))
        val package1Item = arrayOf(gson.fromJson(reader, Package1Item::class.java))

        // Document yaratish uchun
        val doc: XWPFDocument = XWPFDocument()
        // Paragraph yaratish uchun
        var paragraph: XWPFParagraph = doc.createParagraph()

        paragraph.setAlignment(ParagraphAlignment.CENTER)
        var run: XWPFRun = paragraph.createRun()

        run.setText("Hello, World!")
        run.setFontSize(20)
        run.setBold(true)

        paragraph = doc.createParagraph()
        run = paragraph.createRun()


        // jadval yaratish uchun
        val table = doc.createTable()

        // birinchi row
        var row = table.getRow(0)
        var cell = row.getCell(0)

        cell.text = "ID"
        row.createCell().text = "User_Id"
        row.createCell().text = "Title"


        for (i in package1Item.indices) {
            row = table.createRow()
            row.getCell(0).text = package1Item[i].user_id.toString()
            row.getCell(0).text = package1Item[i].email.toString()
            row.getCell(0).text = package1Item[i].name.toString()
        }


//         run.addTab();
//         run.setText("Word, excel va pdf fayllarni yaratish, o'qish va o'zgartirish uchun Apache POI kutubxonasidan foydalanish.");

        val outputStream = FileOutputStream(File("src/main/resources/HelloWorld.docx"))
        doc.write(outputStream)
        outputStream.close()

    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}