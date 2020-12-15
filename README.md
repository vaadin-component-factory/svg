# Vaadin Svg for Flow

Vaadin Svg for Flow is a UI component add-on for Vaadin that allows drawing SVG graphics from the server side.

## License & Author

This Add-on is distributed under Apache 2.0

Component Factory Svg is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)


### Installing
Add Svg to your project
```xml
<dependencies>
  <dependency>
    <groupId>com.vaadin</groupId>
    <artifactId>vcf-svg-flow</artifactId>
    <version>${vaadin.svg.version}</version>
  </dependency>
</dependencies>
```

### Using Vaadin Svg

For screenshots and a live demo, check out the Vaadin Directory listing here: https://vaadin.com/directory/component/svg-component

#### Basic use
```java
Svg svg = new Svg();
svg.add(new Circle("c1", 50));
//add this component to your layout
add(svg); 
```

## Setting up for development

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone git@github.com:vaadin/vcf-svg-flow.git
```

To build and install the project into the local repository run

```mvn install -DskipITs```

in the root directory. `-DskipITs` will skip the integration tests, which require a TestBench license. If you want to run all tests as part of the build, run

```mvn install```

To compile and run demos locally execute

```
mvn compile
mvn -pl vcf-svg-flow-demo -Pwar jetty:run
```
