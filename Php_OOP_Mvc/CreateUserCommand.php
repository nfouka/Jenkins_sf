<?php 

require_once "bootstrap.php";
require './vendor/autoload.php';
require_once 'src/Product.php';
require './src/utils/Utils.php';
require './src/Model/user.php' ; 
require 'GetConnectionDoctrine.php' ; 

use Symfony\Component\Console\Command\Command;
use Symfony\Component\Console\Input\InputInterface;
use Symfony\Component\Console\Output\OutputInterface;
use Symfony\Component\Console\Application;
use Symfony\Component\Config\FileLocator;
use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;
use Symfony\Component\Config\Loader\LoaderResolver;
use Symfony\Component\Config\Loader\DelegatingLoader;
use Symfony\Component\Console\Formatter\OutputFormatterStyle;

use Symfony\Component\DependencyInjection\ContainerBuilder;

class CreateUserCommand extends Command
{
    
    private $em ; 

    public function __construct(array $conn) {
        parent::__construct();
                
        // Create a simple "default" Doctrine ORM configuration for Annotations
$isDevMode = true;
$config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src"), $isDevMode);
// or if you prefer yaml or XML
//$config = Setup::createXMLMetadataConfiguration(array(__DIR__."/config/xml"), $isDevMode);
//$config = Setup::createYAMLMetadataConfiguration(array(__DIR__."/config/yaml"), $isDevMode);


// obtaining the entity manager
        $this->em = EntityManager::create($conn, $config);
    }
    
    protected function configure()
    {
         $this
        // the name of the command (the part after "bin/console")
        ->setName('app:create-users')
        ->addArgument('n', Symfony\Component\Console\Input\InputArgument::REQUIRED)

        // the short description shown while running "php bin/console list"
        ->setDescription('Creates new users.')

        // the full command description shown when running the command with
        // the "--help" option
        ->setHelp("This command allows you to create users...") ; 
    }

    protected function execute(InputInterface $input, OutputInterface $output)
    {
        
        $entityManager = $this->em ; 
        $style = new OutputFormatterStyle('yellow', 'red');
        $output->getFormatter()->setStyle('fire', $style);
       
        for($i=0 ; $i< $input->getArgument('n'); $i++) {
        $product = new \src\Product() ; 
        $product->setName("Product N°". rand(0, 999999));
        $entityManager->persist($product);
        $entityManager->flush();
         $output->write('<fire>create a user. id '.$i."<fire>\n");
        }
        
        
 // outputs multiple lines to the console (adding "\n" at the end of each line)
    $output->writeln([
        'User Creator',
        '============',
        '',
    ]);

    // outputs a message followed by a "\n"
    $output->writeln('Whoa!');

    // outputs a message without adding a "\n" at the end of the line
    $output->write('You are about to ');
    $output->write('create a user.');
    
$config = new \Doctrine\DBAL\Configuration() ; 
$connectionParams = array(
    'dbname'    => 'symfony2',
    'user'      => 'root',
    'password'  => 'root',
    'host'      => 'localhost',
    'port'      =>  3306,
    'charset'   => 'utf8',
    'driver'    => 'pdo_mysql',
);
$dbh = \Doctrine\DBAL\DriverManager::getConnection($connectionParams, $config);
$productRepository = $this->em->getRepository('src\Product')->findAll() ; 

$query = $this->em->createQuery('SELECT u FROM src\Product u');
$users = $query->getResult(); 

    

try {
    $value = \Symfony\Component\Yaml\Yaml::parse(file_get_contents(__DIR__.'/app/config/parameters.yml'));
    print_r($value) ; 
} catch (ParseException $e) {
    printf("Unable to parse the YAML string: %s", $e->getMessage());
}

        }
}


$em = $container->get('doctrine.manager')->getEntityManager()  ;  
$rep = $em->getRepository('src\Product')->findAll() ;
print_r($rep) ; 


use Symfony\Component\Translation\Translator;
use Symfony\Component\Translation\MessageSelector;
use Symfony\Component\Translation\Loader\YamlFileLoader;
use Symfony\Component\Translation\Dumper\JsonFileDumper;

$translator = new Translator('es_ES');
 
$translator->addLoader('array', new \Symfony\Component\Translation\Loader\ArrayLoader());
 
$translator->addResource('array', array(
    'hello world!' => '¡hola mundo!',
    'hello %name%!' => '¡hola %name%!'
), 'es_ES');

$translator->addResource('array', array(
    'hello world!' => 'salut tout le monde',
    'hello %name%!' => 'salut %name%!'
), 'fr_FR');
 
$translator->addResource('array', array(
    'hello world!' => 'Olá mundo!',
    'hello %name%!' => 'Olá %name%!'
), 'pt');
 
$translator = new Translator('es_ES');
$translator->addLoader('yaml', new YamlFileLoader());
 
$translator->addResource('yaml', __DIR__ . '/app/translations/messages.es_ES.yml' , 'es_ES');
$translator->addResource('yaml', __DIR__ . '/app/translations/messages.fr_FR.yml' , 'fr_FR');
 
var_dump($translator->trans('hello'));


$application    = new Application();
$application->add(new CreateUserCommand(
        \Symfony\Component\Yaml\Yaml::parse(file_get_contents(__DIR__.'/app/config/parameters.yml'))
        ) );
$application->run();


