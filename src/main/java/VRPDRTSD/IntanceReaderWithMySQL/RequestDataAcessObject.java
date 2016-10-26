/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VRPDRTSD.IntanceReaderWithMySQL;

import VRPDRTSD.Request;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renansantos
 */
public class RequestDataAcessObject {

    private Connection connection;

    public RequestDataAcessObject() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addRequestIntoDataBase(Request request) {
        String sql = "insert into request_test "
                + "(request_id, passengerOrigin, passengerDestination, requestDay, pickUpTime, "
                + "deliveryTimeWindowLower, deliveryTimeWindowUpper)"
                + " values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);

            statement.setString(1, request.getRequestId().toString());
            statement.setString(2, request.getPassengerOrigin().getNodeId().toString());
            statement.setString(3, request.getPassengerDestination().getNodeId().toString());
            statement.setString(4, request.getDayRequestWasMade().toString());
            statement.setString(5, request.getPickUpTime().toString());
            statement.setString(6, request.getDeliveryTimeWindowLower().toString());
            statement.setString(7, request.getDeliveryTimeWindowUpper().toString());

            // executa
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Request> getListOfRequest() {
        try {

            List<Request> contatos = new ArrayList<Request>();
            PreparedStatement statement = this.connection.prepareStatement("select * from request_test");
            PreparedStatement statementForNodes = this.connection.prepareStatement("select * from nodes_test");
            ResultSet resultSetForRequests = statement.executeQuery();
            ResultSet rsForNodes = statementForNodes.executeQuery();
            
            while (resultSetForRequests.next()) {
                //Integer requestId, Node passengerOrigin, Node passengerDestination, LocalDateTime dayRequestWasMade,
                //LocalDateTime pickUpTime, LocalDateTime deliveryTimeWindowLower, LocalDateTime deliveryTimeWindowUpper
                //Request contato = new Request(rs.getInt("request_id"),);

                Date requestDay = resultSetForRequests.getDate("requestDay");
                Instant instantRequestDay = Instant.ofEpochMilli(requestDay.getTime());

                Date pickUpTime = resultSetForRequests.getDate("pickUpTime");
                Instant instantPickUpTime = Instant.ofEpochMilli(pickUpTime.getTime());

                Date deliveryTimeWindowLower = resultSetForRequests.getDate("deliveryTimeWindowLower");
                Instant instantDeliveryTimeWindowLower = Instant.ofEpochMilli(deliveryTimeWindowLower.getTime());

                Date deliveryTimeWindowUpper = resultSetForRequests.getDate("deliveryTimeWindowUpper");
                Instant instantDeliveryTimeWindowUpper = Instant.ofEpochMilli(deliveryTimeWindowUpper.getTime());
                
//                Request contato = new Request(rs.getInt("request_id"), rs.getInt("passengerOrigin"), 
//                        rs.getInt("passengerDestination"),LocalDateTime.ofInstant(instantRequestDay, ZoneId.systemDefault()),
//                        LocalDateTime.ofInstant(instantPickUpTime, ZoneId.systemDefault()), 
//                        LocalDateTime.ofInstant(instantDeliveryTimeWindowLower, ZoneId.systemDefault()),
//                        LocalDateTime.ofInstant(instantDeliveryTimeWindowUpper, ZoneId.systemDefault()));
//                //contato.setDataNascimento(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
                //contatos.add(contato);
            }
            resultSetForRequests.close();
            statement.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
