package com.tour.app.common.constants;

public class test {

    public static void main(){

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape triangle = shapeFactory.getShape("Triangle");
        triangle.draw();

    }

    public interface Shape{
        void draw();
    }

    public static class Triangle implements Shape{

        @Override
        public void draw() {
            System.out.println("Drawn Triangle");
        }
    }

    public static class ShapeFactory{

        public Shape getShape(String type){

            if(type == null){
                return null;
            }
            if(type.equalsIgnoreCase("Triangle")){
                return new Triangle();
            }

            return null;
        }
    }


}
