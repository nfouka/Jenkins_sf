<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * 
 * 
 */

namespace src ; 

// src/Product.php
/**
 * @Entity 
 * @Table(name="products")
 **/
class Product
{
    /** @Id 
     *  @Column(type="integer") 
     *  @GeneratedValue(strategy="IDENTITY")
     * **/
    protected $id;
    /** @Column(type="string") 
     * **/
    protected $name;

    function getId() {
        return $this->id;
    }

    function getName() {
        return $this->name;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setName($name) {
        $this->name = $name;
    }


}
