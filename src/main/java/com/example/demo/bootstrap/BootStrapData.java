package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long partCount = partRepository.count();
        long productCount = productRepository.count();

        /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        if (partCount == 0 && productCount == 0) {

            OutsourcedPart Engine= new OutsourcedPart();
            Engine.setCompanyName("Parts Manufacturer");
            Engine.setName("Engine");
            Engine.setInv(5);
            Engine.setPrice(1500.0);
            Engine.setId(100L);

            OutsourcedPart Transmission= new OutsourcedPart();
            Transmission.setCompanyName("Parts Manufacturer");
            Transmission.setName("Transmission");
            Transmission.setInv(5);
            Transmission.setPrice(1000.0);
            Transmission.setId(200L);

            OutsourcedPart Wheels= new OutsourcedPart();
            Wheels.setCompanyName("Parts Manufacturer");
            Wheels.setName("Wheels");
            Wheels.setInv(5);
            Wheels.setPrice(500.0);
            Wheels.setId(300L);

            OutsourcedPart Tires= new OutsourcedPart();
            Tires.setCompanyName("Parts Manufacturer");
            Tires.setName("Tires");
            Tires.setInv(5);
            Tires.setPrice(400.0);
            Tires.setId(400L);

            OutsourcedPart Differential= new OutsourcedPart();
            Differential.setCompanyName("Parts Manufacturer");
            Differential.setName("Differential");
            Differential.setInv(5);
            Differential.setPrice(300.0);
            Differential.setId(500L);

            outsourcedPartRepository.save(Engine);
            outsourcedPartRepository.save(Transmission);
            outsourcedPartRepository.save(Wheels);
            outsourcedPartRepository.save(Tires);
            outsourcedPartRepository.save(Differential);

            Product Sedan= new Product("Sedan",1000.0,10);
            Product Coupe= new Product("Coupe",2000.0,10);
            Product Suv= new Product("Suv",3000.0,10);
            Product Truck= new Product("Truck",4000.0,10);
            Product Convertible= new Product("Convertible", 5000.00, 10);

            productRepository.save(Sedan);
            productRepository.save(Coupe);
            productRepository.save(Suv);
            productRepository.save(Truck);
            productRepository.save(Convertible);


        }


        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
