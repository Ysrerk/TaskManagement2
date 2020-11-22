import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Jsonmake {

    void jsonmake(List<Task> task){


        JSONArray taskList = new JSONArray();
        for (Task stask:task){
            JSONObject taskDetails = new JSONObject();
            JSONObject taskObject = new JSONObject();

            taskDetails.put("id",String.valueOf(stask.getId()));
            taskDetails.put("task_details",String.valueOf(stask.getName()));
            taskDetails.put("DueDate", String.valueOf(stask.getDueDate()));
            taskDetails.put("Status", String.valueOf(stask.getStatus()));
            taskObject.put("task", taskDetails);
            taskList.add(taskObject);



        }

        try (FileWriter file = new FileWriter("tasks3.json")) {

            file.write(taskList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }







    }
}
