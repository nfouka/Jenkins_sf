<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

require_once "bootstrap.php";
require_once 'src/Product.php';

$newProductName = $argv[1];

$product = new Product() ; 
$product->setName($newProductName);

$entityManager->persist($product);
$entityManager->flush();


echo "Created Product with ID " . $product->getId() . "\n";