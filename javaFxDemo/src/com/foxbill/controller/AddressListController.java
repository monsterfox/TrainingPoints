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
    private TableColumn<Person,String> firstNameCol,lastNameCol,emailCol;
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
     *
     * 知识点：
     * setCellValueFactory方法为每列指定了一个单元格工厂（cell factory），这些cell factory是通过PropertyValueFactory类来实现的，它将Person类中对应的属性映射到对应的表格列中。
     * 当数据模型被定义完毕，并且数据被关联到列之后，你可以通过TableView类的setItems方法来向表格中添加数据：如：table.setItems(data)。
     *
     * 由于ObservableList对象具有自动追踪其包含元素的改变的功能，所以TableView的内容将会在数据改变时自动更新。
     */
    public void showTable(ObservableList<Person> personList) {
        //将数据关联到表格中的列
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        //
        tview.setItems(personList);
    }

    //页面初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(">>>>>>>列表页面初始化 initialize>>>>>>>");
        showTable(Container.getPersonData());
        tview.setEditable(true);
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
