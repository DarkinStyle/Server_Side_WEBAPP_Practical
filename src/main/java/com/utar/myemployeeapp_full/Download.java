package com.utar.myemployeeapp_full;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "Download", urlPatterns = {"/download"})
public class Download extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String RootPropertyName = "C:\\Users\\Wai Hin(Darkin)\\Documents\\UTAR_Y3SEM3\\Server_Side\\Workshop\\wildfly-17.0.1.Final\\data";
        String name, Filename;

        name = Filename = null;
        String type = request.getParameter("type");

        OutputStream ost = null;
        BufferedInputStream buffIn = null;
        try {

            if (type!= null && type.equals("pdf")) {
                response.setContentType("application/pdf");
                name = "academic_calendar.pdf";
            }
            if (type!= null && type.equals("word")) {
                response.setContentType("application/vnd.ms-word");
                name = "academic_calendar.doc";
            }
            if (type!= null && type.equals("excel")) {
                response.setContentType("application/vnd.ms-excel");
                name = "academic_calendar.xlsx";
            }
            Filename = RootPropertyName + File.separator + name;
            File reportFile = new File(Filename);
            ost = response.getOutputStream();
            response.addHeader("Content-Disposition", "attachment;filename=" + name);
            buffIn = new BufferedInputStream(new FileInputStream(reportFile));
            int iBuf;
            while ((iBuf = buffIn.read()) != -1) {
                ost.write((byte) iBuf);
            }
            ost.flush();
        } finally {
            buffIn.close();
            ost.close(); } }
}