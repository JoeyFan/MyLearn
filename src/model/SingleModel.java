package model;

/**
 * Created by joey on 14-10-23.
 */
public class SingleModel {
    private static SingleModel singleModel;
    private SingleModel(){};
    public static SingleModel getInstance(){
        if(singleModel==null){
            singleModel=new SingleModel();
        }
        return  singleModel;
    }

    private static class SingModelHandler{
        private final static SingleModel hanlder=new SingleModel();
    }

}
