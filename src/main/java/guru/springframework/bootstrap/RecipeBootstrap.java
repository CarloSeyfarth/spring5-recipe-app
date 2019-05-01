package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    private UnitOfMeasure eachUom;
    private UnitOfMeasure tableSpoonUom;
    private UnitOfMeasure teaSpoonUom;
    private UnitOfMeasure dashUom;
    private UnitOfMeasure pintUom;
    private UnitOfMeasure cupUom;
    private UnitOfMeasure ounceUom;
    private UnitOfMeasure pinchUom;

    private Category americanCat;
    private Category italianCat;
    private Category mexicanCat;
    private Category fastfoodCat;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private void initUOM() {

        String uomNotFound = "Expected UOM not found";

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException(uomNotFound);
        }

        //get optionals
        eachUom = eachUomOptional.get();
        tableSpoonUom = tableSpoonUomOptional.get();
        teaSpoonUom = teaSpoonUomOptional.get();
        dashUom = dashUomOptional.get();
        pintUom = pintUomOptional.get();
        cupUom = cupUomOptional.get();
        ounceUom = ounceUomOptional.get();
        pinchUom = pinchUomOptional.get();
    }

    private void initCategories() {

        String catNotFound = "Expected category not found";

        //get categories
        Optional<Category> americanCatOptional = categoryRepository.findByDescription("American");
        if (!americanCatOptional.isPresent()) {
            throw new RuntimeException(catNotFound);
        }

        Optional<Category> italianCatOptional = categoryRepository.findByDescription("Italian");
        if (!italianCatOptional.isPresent()) {
            throw new RuntimeException(catNotFound);
        }

        Optional<Category> mexicanCatOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCatOptional.isPresent()) {
            throw new RuntimeException(catNotFound);
        }

        Optional<Category> fastfoodCatOptional = categoryRepository.findByDescription("Fast Food");
        if (!fastfoodCatOptional.isPresent()) {
            throw new RuntimeException(catNotFound);
        }

        //get optionals
        americanCat = americanCatOptional.get();
        italianCat = italianCatOptional.get();
        mexicanCat = mexicanCatOptional.get();
        fastfoodCat = fastfoodCatOptional.get();
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>();

        initUOM();
        initCategories();
        recipes.add(YummyGuac());
        recipes.add(YummyTaco());

        return recipes;
    }

    private Recipe YummyGuac() {

        //Create recipe for Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                                 "\n" +
                                 "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                                 "\n" +
                                 "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                                 "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                                 "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                                 "\n" +
                                 "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                                 "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                                 "\n" +
                                 "\n" +
                                 "Read more: https://www.simplyrecipes.com/recipes/perfect_guacamole");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), teaSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUom, guacRecipe));

        guacRecipe.getCategories().add(americanCat);
        guacRecipe.getCategories().add(mexicanCat);

        return guacRecipe;
    }

    private Recipe YummyTaco() {

        //Create recipe for Yummy Tacos
        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacoRecipe.setPrepTime(9);
        tacoRecipe.setCookTime(20);
        tacoRecipe.setDifficulty(Difficulty.MODERATE);
        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges." +
                "\n" +
                "\n" +
                "Read more: https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
        tacoNotes.setRecipe(tacoRecipe);
        tacoRecipe.setNotes(tacoNotes);

        tacoRecipe.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(0.5), teaSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("garlic, finely chopped", new BigDecimal(1), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), tableSpoonUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("boneless chicken thighs", new BigDecimal(6), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), ounceUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(0.5), pintUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(0.25), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), eachUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(0.5), cupUom, tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(1), eachUom, tacoRecipe));

        tacoRecipe.getCategories().add(americanCat);
        tacoRecipe.getCategories().add(mexicanCat);

        return tacoRecipe;
    }
}
