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
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, request.getRequestId().toString());
            stmt.setString(2, request.getPassengerOrigin().getNodeId().toString());
            stmt.setString(3, request.getPassengerDestination().getNodeId().toString());
            stmt.setString(4, request.getDayRequestWasMade().toString());
            stmt.setString(5, request.getPickUpTime().toString());
            stmt.setString(6, request.getDeliveryTimeWindowLower().toString());
            stmt.setString(7, request.getDeliveryTimeWindowUpper().toString());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Request> getListOfRequest() {
        try {

            List<Request> contatos = new ArrayList<Request>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome = 'Renan'");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //Integer requestId, Node passengerOrigin, Node passengerDestination, LocalDateTime dayRequestWasMade,
                //LocalDateTime pickUpTime, LocalDateTime deliveryTimeWindowLower, LocalDateTime deliveryTimeWindowUpper
                //Request contato = new Request(rs.getInt("request_id"),);

                Date requestDay = rs.getDate("requestDay");
                Instant instantRequestDay = Instant.ofEpochMilli(requestDay.getTime());

                Date pickUpTime = rs.getDate("pickUpTime");
                Instant instantPickUpTime = Instant.ofEpochMilli(pickUpTime.getTime());

                Date deliveryTimeWindowLower = rs.getDate("deliveryTimeWindowLower");
                Instant instantDeliveryTimeWindowLower = Instant.ofEpochMilli(deliveryTimeWindowLower.getTime());

                Date deliveryTimeWindowUpper = rs.getDate("deliveryTimeWindowUpper");
                Instant instantDeliveryTimeWindowUpper = Instant.ofEpochMilli(deliveryTimeWindowUpper.getTime());
                
//                Request contato = new Request(rs.getInt("request_id"), rs.getInt("passengerOrigin"), 
//                        rs.getInt("passengerDestination"),LocalDateTime.ofInstant(instantRequestDay, ZoneId.systemDefault()),
//                        LocalDateTime.ofInstant(instantPickUpTime, ZoneId.systemDefault()), 
//                        LocalDateTime.ofInstant(instantDeliveryTimeWindowLower, ZoneId.systemDefault()),
//                        LocalDateTime.ofInstant(instantDeliveryTimeWindowUpper, ZoneId.systemDefault()));
//                //contato.setDataNascimento(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
                //contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
