<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Utils
 *
 * @author nadir
 */

namespace src\utils  ; 
require_once "bootstrap.php";
use Symfony\Component\DependencyInjection\ContainerBuilder;
use Symfony\Component\DependencyInjection\Definition;
use Symfony\Component\Config\FileLocator;
use Symfony\Component\DependencyInjection\Loader\YamlFileLoader;



class Utils {

    public function getResult(){
        echo "DI with Symfony2 \n" ; 
    }
}

class AwareContainer {
      public function getResult(){
        echo "DI with Symfony2 \n" ; 
    }
}


use Symfony\Component\DependencyInjection\Loader\XmlFileLoader;

$container = new ContainerBuilder();
$loader = new XmlFileLoader($container, new FileLocator(__DIR__));
$loader->load('./../../app/config/service.xml');