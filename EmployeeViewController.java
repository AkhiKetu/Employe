package employee.employee;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeViewController
{
    @javafx.fxml.FXML
    private ToggleGroup genderGroup;
    @javafx.fxml.FXML
    private TextField idField;
    @javafx.fxml.FXML
    private DatePicker dojPicker;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> salaryCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentCol;
    @javafx.fxml.FXML
    private ComboBox<Employee> idBox;    //initialize ComboBox ----> Employee--Integer
    @javafx.fxml.FXML
    private TextField minSalaryField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TableView<Employee> empTable;
    @javafx.fxml.FXML
    private ComboBox<String> designationBox;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> empIdCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, LocalDate> dojCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> empNameCol;
    @javafx.fxml.FXML
    private TextField salaryField;

    //Using ArrayList to store Employee Objects

    private final ArrayList<Employee> empList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        //connect between table and arraylist
        designationBox.getItems().addAll("Manager", "Developer", "Tester", "HR");
        empIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));    //Find Employee Class ID Property And Getters
        empNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));    //Find Employee Class Name Property And Getters
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));    //Find Employee Class Salary Property And Getters
        dojCol.setCellValueFactory(new PropertyValueFactory<>("doj"));    //Find Employee Class DOJ Property And Getters
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("designation"));    //Find Employee Class Designation Property And Getters


    }

    @javafx.fxml.FXML
    public void onShowDetailsButtonClick(ActionEvent actionEvent) {
        Employee e =idBox.getSelectionModel().getSelectedItem();   //Get Selected Item from ComboBox
        Alert employeeInformation = new Alert(Alert.AlertType.INFORMATION); //Creating Alert Box of Type Information
        String content = "Employee Name: " + e.getName() + "Employee Id: " + e.getId(); //Creating Content for Alert Box
        employeeInformation.setContentText(" "); //Setting Content of Alert Box to content String Variable created above content = "Employee Name: " + e.getName() + "Employee Id: " + e.getId();

        employeeInformation.show(); //Showing Alert Box

    }

    @javafx.fxml.FXML
    public void onLoadButtonClick(ActionEvent actionEvent) {
        int minSalary = Integer.parseInt(minSalaryField.getText()); //Converting String to Integer

        ArrayList <Employee> filteredList = new ArrayList<>(); //Creating ArrayList to store Filtered Employee Objects

        empTable.getItems().clear(); //Clearing TableView

        for (Employee i : empList){ //Iterating through empList
            if (i.getSalary() >= minSalary){ //Checking if Salary is greater than or equal to minSalary
                filteredList.add(i); //Adding Employee Object to filteredList
            }
        }
        for (Employee i : filteredList){ //Iterating through filteredList
            empTable.getItems().add(i); //Adding Employee Object to TableView
        }
    }

    @javafx.fxml.FXML
    public void onAddEmployeeButtonClick(ActionEvent actionEvent) {

        int id; //We have to write this outside the if block
        if (!idField.getText().isEmpty()){   //NOt Empty
            id = Integer.parseInt(idField.getText());  //Converting String to Integer

            for(Employee i : empList){    //Check if ID already exists
                if(i.getId() == id){
                    return;
                }
            }

        }else {
            return;
        }

        String name;   //we have to write this outside the if block
        if (!nameField.getText().isEmpty()) {   //NOt Empty
            name = nameField.getText();//Converting String to Integer
        }else {
            return;
        }

        String designation; //we have to write this outside the if block
        if (!designationBox.getSelectionModel().getSelectedItem().isEmpty()){
            designation = designationBox.getSelectionModel().getSelectedItem();
        } else {
            return;
        }

        int salary; //we have to write this outside the if block
        if (!salaryField.getText().isEmpty()){
            salary =Integer.parseInt(salaryField.getText());

            if(salary <= 0){
                return;
            }
        } else {
            return;
        }

        LocalDate doj; //we have to write this outside the if block
        if (!(dojPicker.getValue() == null)){     //Not Empty(!dojPicker.getValue().isEmpty())
            doj = dojPicker.getValue();
            if (doj.isAfter(LocalDate.now())){ //Check if Date is after current date
                return;
            }
        } else {
            return;
        }
        RadioButton genderButton = (RadioButton) genderGroup.getSelectedToggle(); //Converting to RadioButton Type-casting
        String gender; //we have to write this outside the if block
        if (!(genderButton == null)){                   //check if genderButton is not null
        gender = genderButton.getText();
        } else {
            return;
        }

        //Creating Employee Object

        Employee emp = new Employee(id, name, designation, salary, doj,gender); //Creating Employee Object
        empList.add(emp); //Adding Employee Object to ArrayList

        idBox.getItems().add(emp); //Adding Employee Object to ComboBox



    }
}