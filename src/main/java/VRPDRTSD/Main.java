/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VRPDRTSD;

import VRPDRTSD.IntanceReaderWithMySQL.RequestDataAcessObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.joda.time.LocalDateTime;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author renansantos
 */
public class Main {

    // AIzaSyCm6B9RvXUIA1yr-iYAWsr1OV0xJCp1kOw 
    // AIzaSyB3pjdG8EsYWb-K-fzPpxCFPcnFBztm-wY //distance matrix
    public static void main(String[] args) throws SQLException, MalformedURLException, IOException, ParseException {
//        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/VRPDRTSD", "root", "");
//        System.out.println("Conectado!");
//        conexao.close();
//        String chave = "AIzaSyB3pjdG8EsYWb-K-fzPpxCFPcnFBztm-wY";
//        //String endereco = "http://maps.googleapis.com/maps/api/staticmap?center=-22.8634,-43.1792&amp;zoom=" + 12 + "&amp;size=640x640&amp;maptype=" + "satellite" + "&amp;key=" + chave + "&amp;sensor=false&amp;format=jpg";
//        String endereco = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Formiga&destinations=Belo+Horizonte&key=" + chave;
//
//        URL url = new URL(endereco);
//
//        Reader br = new InputStreamReader(url.openStream());

//        JSONParser parser = new JSONParser();
//        JSONObject jsonObjeto = (JSONObject) parser.parse(br);
        //System.out.println(jsonObjeto);
        //parser = new JSONParser();
        //BufferedImage img = ImageIO.read(con.getInputStream());
//        LocalDateTime agora = LocalDateTime.now();
//        LocalDateTime depois = LocalDateTime.now().plusHours(2);
//        
//        Duration tempoEntre;
//        tempoEntre = Duration.between(agora, depois);
//        
//        LocalDateTime agora = LocalDateTime.now();
//        LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
//        Duration duration;
        //duration = Duration.between(agora, daquiAUmaHora);
//        Request request;
//        request = new Request(1,null,null,null,null,null);
        //request.teste();
       

//dao.addNodeIntoDataBase(node);
        //nodes = ArrayList<>();
        Node node0 = new Node(0, 40.7143528, -74.0059731);
        Node node1 = new Node(1, 40.7143528, -74.0059731);
        Node node2 = new Node(2, 40.7143528, -74.0059731);
        Node node3 = new Node(3, 40.7143528, -74.0059731);
        Node node4 = new Node(4, 40.7143528, -74.0059731);
        Node node5 = new Node(5, 40.7143528, -74.0059731);
        Node node6 = new Node(6, 40.7143528, -74.0059731);
        
        Request requestA = new Request(0, node2, node3, java.time.LocalDateTime.now(),java.time.LocalDateTime.now(),java.time.LocalDateTime.now().plusMinutes(40),java.time.LocalDateTime.now().plusMinutes(55));
        Request requestB = new Request(1, node2, node5, java.time.LocalDateTime.now(),java.time.LocalDateTime.now(),java.time.LocalDateTime.now().plusMinutes(40),java.time.LocalDateTime.now().plusMinutes(55));
        Request requestC = new Request(2, node4, node6, java.time.LocalDateTime.now(),java.time.LocalDateTime.now(),java.time.LocalDateTime.now().plusMinutes(50),java.time.LocalDateTime.now().plusMinutes(65));
        Request requestD = new Request(3, node2, node1, java.time.LocalDateTime.now(),java.time.LocalDateTime.now(),java.time.LocalDateTime.now().plusMinutes(50),java.time.LocalDateTime.now().plusMinutes(65));
        
        List<Request> requests = new ArrayList<>();
        requests.add(requestA);
        requests.add(requestB);
        requests.add(requestC);
        requests.add(requestD);
        
        RequestDataAcessObject dao = new RequestDataAcessObject();
        dao.addRequestIntoDataBase(requestA);
        dao.addRequestIntoDataBase(requestB);
        dao.addRequestIntoDataBase(requestC);
        dao.addRequestIntoDataBase(requestD);
        //requests.forEach(u-> dao.addRequestIntoDataBase(u));
    }

}
