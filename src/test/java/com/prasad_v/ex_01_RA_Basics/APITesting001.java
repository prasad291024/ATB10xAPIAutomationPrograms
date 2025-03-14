package com.prasad_v.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting001 {
    public static void main(String[] args) {
        // first program on rest assured
        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        // Full URL - https://api.zippopotam.us/IN/110001
        // Base URI - https://api.zippopotam.us
        // Base Path - /IN/110001
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/110001")
                    .when()
                        .get()
                    .then()
                        .log().all().statusCode(200);



        //**************take Pincode as input from user***********************
//        Scanner scan =  new Scanner(System.in);
//        System.out.println("Enter the pincode");
//        String pincode = scan.nextLine();
//        RestAssured.given()
//                .baseUri("https://api.zippopotam.us")
//                .basePath("/IN/"+ pincode)
//                .when()
//                .get()
//                .then()
//                .log().all().statusCode(200);



    }
}
