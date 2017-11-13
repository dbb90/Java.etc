/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processInputFile;

/**
 *
 * @author dbb09
 */
private List<YourJavaItem> processInputFile(String inputFilePath) {

    List<YourJavaItem> inputList = new ArrayList<YourJavaItem>();

    try{

      File inputF = new File(inputFilePath);

      InputStream inputFS = new FileInputStream(inputF);

      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

      // skip the header of the csv

      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());

      br.close();

    } catch (FileNotFoundException|IOException e) {

      ....

    }

    return inputList ;

}