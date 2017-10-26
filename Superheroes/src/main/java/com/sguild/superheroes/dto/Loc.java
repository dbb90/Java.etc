/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.superheroes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dbb09
 */

// Wanna use some lombok? https://projectlombok.org/features/all
// Make sure you update your pom and download your dependencies!

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loc {
    
    private int locid;
    private String locName;
    private String locDesc;
    private String locAddress;
    private String locLat;
    private String locLong;

}
