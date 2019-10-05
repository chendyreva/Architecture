package com.company.magicnum;

public class Magicnum {
    public static void main(String[] args) {
        PotentialEnergy potentialEnergy = new PotentialEnergy();        
        potentialEnergy.potentialEnergy();
        }
    }

  class PotentialEnergy {

      double mass = 2.3;
      double height = 4.6;     
      static final double GRAVITATIONAL_CONSTANT = 9.81;


      // Constructor Declaration of Class
      public PotentialEnergy() {
          this.mass = mass;
          this.height = height;          
      }
      // пример с магическим числом
      double potentialEnergy(double mass, double height) {
          return mass * height * 9.81;
      }
      
      // решение правильное
      double potentialEnergy1(double mass, double height) {
          return mass * height * GRAVITATIONAL_CONSTANT;
      }

      public double potentialEnergy() {
          double potentialEnergy = potentialEnergy1();
          return potentialEnergy;
      }

      private double potentialEnergy1() {
          return mass * height * GRAVITATIONAL_CONSTANT;
      }
  }

