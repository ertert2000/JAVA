package com.proghelp;

import java.awt.FileDialog;
import java.io.File;
import org.w3c.dom.*;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Serialization {

    private static final Logger logger = LogManager.getLogger(Serialization.class);

    public static void SaveButtonClick(JTable table) 
    {
        FileDialog save = new FileDialog(Main.frame, "Сохранение данных", FileDialog.SAVE);
        save.setFile("*.xml");
        save.setVisible(true);
    
        String fileName = save.getDirectory() + save.getFile();
        if (fileName == null) 
        {
            logger.warn("Пользователь отменил сохранение файла.");
            return;
        }
    
        try 
        {
            logger.info("Начало сохранения данных в файл: " + fileName);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
    
            Element rootElement = doc.createElement("Appointments");
            doc.appendChild(rootElement);
    
            for (int i = 0; i < model.getRowCount(); i++) 
            {
                Element appointment = doc.createElement("Appointment");
                rootElement.appendChild(appointment);
    
                Element doctor = doc.createElement("Врач");
                doctor.appendChild(doc.createTextNode(model.getValueAt(i, 0).toString()));
                appointment.appendChild(doctor);
    
                Element time = doc.createElement("Время");
                time.appendChild(doc.createTextNode(model.getValueAt(i, 1).toString()));
                appointment.appendChild(time);
    
                Element specialization = doc.createElement("specialization");
                specialization.appendChild(doc.createTextNode(model.getValueAt(i, 2).toString()));
                appointment.appendChild(specialization);
    
                Element patient = doc.createElement("pacient");
                patient.appendChild(doc.createTextNode(model.getValueAt(i, 3).toString()));
                appointment.appendChild(patient);
            }
    
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
    
            logger.info("Данные успешно сохранены в файл: " + fileName);
            JOptionPane.showMessageDialog(null, "Данные успешно сохранены в файл appointments.xml.");
        } 
        catch (Exception e) 
        {
            logger.error("Ошибка при сохранении данных: " + e.getMessage(), e);
            JOptionPane.showMessageDialog(null, "Ошибка при сохранении данных: " + e.getMessage());
        }
    }
    
    public static void LoadButtonClick(JTable table, DoctorTableModel model) 
    {
        FileDialog load = new FileDialog(Main.frame, "Загрузка данных", FileDialog.LOAD);
        load.setFile("*.xml");
        load.setVisible(true);
    
        String fileName = load.getDirectory() + load.getFile();
        if (fileName == null)
        {
            logger.warn("Пользователь отменил загрузку файла.");
            return;
        }
    
        try 
        {
            logger.info("Начало загрузки данных из файла: " + fileName);
    
            File file = new File(fileName);
            if (!file.exists()) 
            {
                logger.error("Файл не найден: " + fileName);
                JOptionPane.showMessageDialog(null, "Файл не найден.");
                return;
            }
    
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
    
            NodeList nodeList = doc.getElementsByTagName("Appointment");
    
            model.setRowCount();
    
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element element = (Element) node;
    
                    String doctor = element.getElementsByTagName("Врач").item(0).getTextContent();
                    String time = element.getElementsByTagName("Время").item(0).getTextContent();
                    String specialization = element.getElementsByTagName("specialization").item(0).getTextContent();
                    String patient = element.getElementsByTagName("pacient").item(0).getTextContent();

                    Doctor doctorTemp = new Doctor(doctor, specialization, time);

                    model.addRow(doctorTemp);
                }
            }
    
            logger.info("Данные успешно загружены из файла: " + fileName);
            JOptionPane.showMessageDialog(null, "Данные успешно загружены из файла appointments.xml.");
        }
        catch (Exception e)
        {
            logger.error("Ошибка при загрузке данных: " + e.getMessage(), e);
            JOptionPane.showMessageDialog(null, "Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}