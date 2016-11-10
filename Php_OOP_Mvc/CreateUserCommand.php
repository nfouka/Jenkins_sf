<?php 

require_once "bootstrap.php";
require './vendor/autoload.php';
require_once 'src/Product.php';

use Symfony\Component\Console\Command\Command;
use Symfony\Component\Console\Input\InputInterface;
use Symfony\Component\Console\Output\OutputInterface;
use Symfony\Component\Console\Application;
use Symfony\Component\Config\FileLocator;
use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;
use Symfony\Component\Config\Loader\LoaderResolver;
use Symfony\Component\Config\Loader\DelegatingLoader;


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
        
       
        for($i=0 ; $i< $input->getArgument('n'); $i++) {
        $product = new \src\Product() ; 
        $product->setName("Product N°". rand(0, 999999));
        $entityManager->persist($product);
        $entityManager->flush();
         $output->write('create a user. id '.$i."\n");
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

$application = new Application();
$application->add(new CreateUserCommand(
        \Symfony\Component\Yaml\Yaml::parse(file_get_contents(__DIR__.'/app/config/parameters.yml'))
        ) );
$application->run();

