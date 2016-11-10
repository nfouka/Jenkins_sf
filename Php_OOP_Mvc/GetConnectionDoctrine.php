<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

require_once "vendor/autoload.php";

/**
 * Description of GetConnectionDoctrine
 *
 * @author nadir
 */
class GetConnectionDoctrine {
    protected $entityManager ; 
    public function __construct() {
        // Create a simple "default" Doctrine ORM configuration for Annotations
            $isDevMode = true;
            $config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src"), $isDevMode);
            $conn = \Symfony\Component\Yaml\Yaml::parse(file_get_contents(__DIR__.'/app/config/parameters.yml')) ; 
            $this->entityManager = EntityManager::create($conn, $config);
    }
    
    function getEntityManager() {
        return $this->entityManager;
    }

}
