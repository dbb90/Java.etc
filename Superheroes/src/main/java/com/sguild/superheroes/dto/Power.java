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
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Power {

    private int powerid;
    private String PowerName;
    private String PowerDesc;

}
