<?php

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

require_once "vendor/autoload.php";

// Create a simple "default" Doctrine ORM configuration for Annotations
$isDevMode = true;
$config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src"), $isDevMode);
$conn =  \Symfony\Component\Yaml\Yaml::parse(file_get_contents(__DIR__.'/app/config/parameters.yml')) ; 
$entityManager = EntityManager::create($conn, $config);