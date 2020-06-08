package com.bandwidth.engineering.tools.portal.dashboard.api.service;

import com.bandwidth.engineering.tools.portal.dashboard.api.model.Connector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ConnectorService {


    public String getConnectors(String dataCenterValue, String clusterValue) {
        final String connectorsUri = "https://" + clusterValue + ".apps." + dataCenterValue + "1.ocp.bandwidth.com/connectors?expand=status";
        RestTemplate restTemplate = new RestTemplate();
        String connectors = restTemplate.getForObject(connectorsUri, String.class);
        ArrayList<Connector> connectorsList=new ArrayList<Connector>();
        try {

            JSONObject connectorsObject = new JSONObject(connectors);
            JSONArray connectorNames = connectorsObject.names();
            for (int i = 0; i < connectorNames.length(); i++) {
                String curConnectorName = connectorNames.getString(i);
                JSONObject curConnectorWrapper = connectorsObject.getJSONObject(curConnectorName);
                JSONObject curConnector = curConnectorWrapper.getJSONObject("status");
                JSONObject curConnectorInfo = curConnector.getJSONObject("connector");

                String curConnectorStatus = curConnectorInfo.getString("state");
                String curConnectorType = curConnector.getString("type");

                JSONArray tasks = curConnector.getJSONArray("tasks");

                for (int j = 0; j < tasks.length(); j++) {
                    JSONObject curTask = tasks.getJSONObject(j);
                    int curTaskID = curTask.getInt("id");
                    String curTaskStatus = curTask.getString("state");

                    Connector cur = new Connector(curConnectorName);
                    cur.setConnectorStatus(curConnectorStatus);
                    cur.setType(curConnectorType);
                    cur.setTaskID(curTaskID);
                    cur.setTaskStatus(curTaskStatus);
                    connectorsList.add(cur);
                }


            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       String connectorsListString= new Gson().toJson(connectorsList);
        return connectorsListString;
    }
}
