/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VRPDRTSD;

import Algorithms.BuildGreedySolution;
import VRPDRTSD.IntanceReaderWithMySQL.AdjacenciesDataAcessObject;
import VRPDRTSD.IntanceReaderWithMySQL.NodeDataAcessObject;
import VRPDRTSD.IntanceReaderWithMySQL.RequestDataAcessObject;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
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
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import jdk.internal.org.xml.sax.XMLReader;
import org.joda.time.LocalDateTime;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author renansantos
 */
public class Main {

    // Keys for Google Maps API
    // AIzaSyCm6B9RvXUIA1yr-iYAWsr1OV0xJCp1kOw 
    // AIzaSyB3pjdG8EsYWb-K-fzPpxCFPcnFBztm-wY //distance matrix
    public static void main(String[] args) throws SQLException, MalformedURLException, IOException, ParseException {

//        NodeDataAcessObject ndao = new NodeDataAcessObject();
//        List<Node> nodes = ndao.getListOfNodes();
//
//        nodes.forEach(u -> System.out.println(u));
//
//        RequestDataAcessObject dao = new RequestDataAcessObject();
//        List<Request> listOfRequests = dao.getListOfRequestUsingNodesList(nodes);
        //listOfRequests.forEach(System.out::println);
        //listOfRequests.sort(Comparator.comparing(Request::getDeliveryTimeWindowLower));
        //listOfRequests.forEach(System.out::println);
//        Integer lowerTimeWindow = listOfRequests.stream()
//                .mapToInt(u -> u.getDeliveryTimeWindowLower()
//                .getMinute()).min().getAsInt();
//        System.out.println("teste = " + lowerTimeWindow);
        //listOfRequests.forEach(System.out::println);
//        System.out.println("teste nos= ");
//        Set<Node> originNodes = listOfRequests.stream()
//                .map(Request::getPassengerDestination)
//                .collect(Collectors.toCollection(HashSet::new));
//        originNodes.forEach(System.out::println);
//        Map<Node, List<Request>> listOfPassengersWhoBoardsInNode = listOfRequests.stream()
//                .collect(Collectors.groupingBy(Request::getPassengerOrigin));
//        
//        Map<Node, List<Request>> listOfPassengersWhoLeavesInNode = listOfRequests.stream()
//                .collect(Collectors.groupingBy(Request::getPassengerDestination));
//
//        System.out.println(listOfPassengersWhoBoardsInNode.keySet());
//        
//        listOfRequests.stream().sorted(Comparator.comparing(Request::getDeliveryTimeWindowLower))
//                .forEach(System.out::println);
//        
//        System.out.println("Size of list" + listOfRequests.size());
//        AdjacenciesDataAcessObject adao = new AdjacenciesDataAcessObject();
//        Duration[][] duration = adao.getDurationBetweenNodes(12);
//        double[][] distance = adao.getDistanceBetweenNodes(12);
//        System.out.println("duração = " + distance[0][1]);
        BuildGreedySolution buildGreedySolutionAlgorithm = new BuildGreedySolution();
    }

}
