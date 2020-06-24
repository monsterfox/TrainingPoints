package com.foxbill.controller;

import com.foxbill.data.Container;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.foxbill.domain.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//public class AddressListController {
public class AddressListController implements Initializable {
    @FXML
    private Button addBtn,delBtn;
    @FXML
    private TableColumn<Person,String> firstName,lastName,email;
    @FXML
    private TableView tview;

    @FXML
    protected void handleAddAction(ActionEvent event) throws IOException {
        System.out.println(">>>>>>>新增条目>>>>>>>");
        Parent parent = FXMLLoader.load(getClass().getResource("../view/addAddress.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.hide();
        stage.setTitle("新增条目");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }



    @FXML
    protected void handleDeleteAction(ActionEvent event) throws IOException {
        System.out.println(">>>>>>>删除条目>>>>>>>");
        Object selectedItem = tview.getSelectionModel().getSelectedItem();
        Container.personList.remove(selectedItem);
        showTable(Container.getPersonData());
    }


    /**
     * 显示表格数据
     * @param personList
     */
    public void showTable(ObservableList<Person> personList) {
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tview.setItems(personList);
    }

    //页面初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(">>>>>>>列表页面初始化 initialize>>>>>>>");
        showTable(Container.getPersonData());
        /*tview.getSelectionModel().selectedItemProperty().addListener(// 选中某一行
                new ChangeListener<ILayer>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends ILayer> observableValue,
                            ILayer oldItem, ILayer newItem) {
                        System.out.println(newItem.getLayerName());
                    }*/
    }
}
