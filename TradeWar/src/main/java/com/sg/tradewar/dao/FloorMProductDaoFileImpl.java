/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradewar.dao;


public class FloorMProductDaoFileImpl {

//    private final List<Spell> products = new ArrayList<>();
//
//    @Override
//    public Spell addProduct(Spell product) {
//        products.add(product);
//        return product;
//    }
//
//    @Override
//    public Spell getProduct(String productType) {
//        Iterator<Spell> iterated = products.iterator();
//        while (iterated.hasNext()) {
//            Spell currentProduct = iterated.next();
//            if (currentProduct.getProductType().equals(productType)) {
//                return currentProduct;
//            } else {
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Spell removeProduct(Spell product) {
//        products.remove(product);
//        return product;
//    }
//
//    @Override
//    public Spell editProduct(Spell oldProduct, Spell newProduct) {
//        products.remove(oldProduct);
//        products.add(newProduct);
//        return newProduct;
//    }
//
////    @Override
////    public List<Spell> getAllProducts() {
////               return products.stream().collect(Collectors.toList());
////    }
//
//    public void readPData() throws TradeWarPersistenceException {
//        Scanner scan;
//        try {
//            scan = new Scanner(new BufferedReader(new FileReader(".\\Data\\Products.txt")));
//        } catch (FileNotFoundException e) {
//            throw new TradeWarPersistenceException("ERROR: Could not read products from file!");
//        }
//        products.clear();
//        String currentLine;
//        String[] currentTokens;
//        while (scan.hasNextLine()) {
//            currentLine = scan.nextLine();
//            currentTokens = currentLine.split(",");
//            int i = 0;
//            for (String currentString : currentTokens) {
//                currentTokens[i] = currentString.trim();
//                i++;
//            }
//            BigDecimal materialCost = new BigDecimal(currentTokens[1]);
//            BigDecimal laborCost = new BigDecimal(currentTokens[2]);
//            Spell newProduct = new Spell(currentTokens[0], materialCost, laborCost);
//            products.add(newProduct);
//        }
//    }
}
