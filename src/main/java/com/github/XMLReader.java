package com.github;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    public List<Article> readXML(String path) {
        List<Article> articles = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            doc.getDocumentElement().normalize();
            // получаем узлы с именем article
            NodeList nodeList = doc.getElementsByTagName("article");
            //из загруженного в память XML получаем список объектов Article
            for (int i = 0; i < nodeList.getLength(); i++) {
                articles.add(getArticle(nodeList.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    // создаем из узла документа объект
    private Article getArticle(Node item) {
        Article article = new Article();
        if (item.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) item;
            article.setId_art(Integer.parseInt(getTagValue("id_art", element)));
            article.setName(getTagValue("name", element));
            article.setCode(getTagValue("code", element));
            article.setUserName(getTagValue("username", element));
            article.setGuid(getTagValue("guid", element));
        }
        return article;
    }

    // получаем значение элемента по указанному тегу
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
