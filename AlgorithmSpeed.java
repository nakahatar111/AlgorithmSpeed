import java.util.StringTokenizer;
class AlgorithmSpeed {
  private static int width = 600;
	private static int height = 250;

  private static javax.swing.JButton sortIntsButton;
  private static javax.swing.JButton addToBstButton;
  private static javax.swing.JButton addToTreeSetButton;
  private static javax.swing.JButton addToPriorityQueueButton;
  private static javax.swing.JButton addToHashSetButton;

  private static javax.swing.JLabel sortIntsLabel;
  private static javax.swing.JLabel addToBstLabel;
  private static javax.swing.JLabel addToTreeSetLabel;
  private static javax.swing.JLabel addToPriorityQueueLabel;
  private static javax.swing.JLabel addToHashSetLabel;

  private static javax.swing.JButton searchIntsButton;
  private static javax.swing.JButton searchBstButton;
  private static javax.swing.JButton searchTreeSetButton;
  private static javax.swing.JButton searchPriorityQueueButton;
  private static javax.swing.JButton searchHashSetButton;

  private static javax.swing.JLabel searchIntsLabel;
  private static javax.swing.JLabel searchBstLabel;
  private static javax.swing.JLabel searchTreeSetLabel;
  private static javax.swing.JLabel searchPriorityQueueLabel;
  private static javax.swing.JLabel searchHashSetLabel;

  private static int[] sortValues;
  private static int[] searchValues;
  private static String sortFile;
  private static String searchFile;

  private static int[] sortedValues;
  private static java.util.TreeSet<Integer> treeSetValues;
	private static java.util.HashSet<Integer> hashSetValues;
  private static java.util.PriorityQueue<Integer> priorityQueueValues;
  private static BinarySearchTree bst;

  private static boolean enable_button = false;
	public static void main(String[] args)
	{
    if( args.length != 2 )
		{
			System.out.println("format is: nakahata_p8 \"sort file\" \"search file\"");
			System.exit(0);
		}
    sortFile = args[0];
    searchFile = args[1];

		// create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    // create the menu bar
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		
		// create the one menu
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
		
		// create the menu items for the three menus
		javax.swing.JMenuItem readSortFile = new javax.swing.JMenuItem("Read Sort File");
		javax.swing.JMenuItem readSearchFile = new javax.swing.JMenuItem("Read Search File");
    javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");
		
		// add the one menu to the menu bar
		menuBar.add(fileMenu);
		
		// add the three menu items to the menus
    fileMenu.add(readSortFile);
    fileMenu.add(readSearchFile);
		fileMenu.add(fileExit);

    // create the main button panel to hold the buttons
    javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(buttonPanel, javax.swing.BoxLayout.X_AXIS);
		buttonPanel.setLayout(boxLayout);
    buttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));

    // create a panel to hold the left buttons
		javax.swing.JPanel leftButtonPanel = new javax.swing.JPanel();
    javax.swing.border.LineBorder leftButtonPanelLineBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 5);
    leftButtonPanel.setBorder(leftButtonPanelLineBorder);
    java.awt.GridBagLayout leftButtonPanelGridBagLayout = new java.awt.GridBagLayout();  
    leftButtonPanel.setLayout(leftButtonPanelGridBagLayout);
    java.awt.GridBagConstraints leftButtonPanelConstraints = new java.awt.GridBagConstraints();

		//Left buttons
    sortIntsButton = new javax.swing.JButton("sort ints");
    sortIntsLabel = new javax.swing.JLabel("no result");
    addToBstButton = new javax.swing.JButton("add to bst");
    addToBstLabel = new javax.swing.JLabel("no result");
    addToTreeSetButton = new javax.swing.JButton("add to treeset");
    addToTreeSetLabel = new javax.swing.JLabel("no result");
    addToPriorityQueueButton = new javax.swing.JButton("add to priority queue");
    addToPriorityQueueLabel = new javax.swing.JLabel("no result");
    addToHashSetButton = new javax.swing.JButton("add to hashset");
    addToHashSetLabel = new javax.swing.JLabel("no result");

    //Left button constraints
    leftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
    leftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;

    leftButtonPanelConstraints.gridx = 0;
    leftButtonPanelConstraints.gridwidth = 1;
    leftButtonPanelConstraints.weightx = 1;
    leftButtonPanelGridBagLayout.setConstraints(sortIntsButton, leftButtonPanelConstraints);
    leftButtonPanelConstraints.gridx = 1;
    leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    leftButtonPanelGridBagLayout.setConstraints(sortIntsLabel, leftButtonPanelConstraints);

    leftButtonPanelConstraints.gridx = 0;
    leftButtonPanelConstraints.gridwidth = 1;
    leftButtonPanelGridBagLayout.setConstraints(addToBstButton, leftButtonPanelConstraints);
    leftButtonPanelConstraints.gridx = 1;
    leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    leftButtonPanelGridBagLayout.setConstraints(addToBstLabel, leftButtonPanelConstraints);

    leftButtonPanelConstraints.gridx = 0;
    leftButtonPanelConstraints.gridwidth = 1;
    leftButtonPanelGridBagLayout.setConstraints(addToTreeSetButton, leftButtonPanelConstraints);
    leftButtonPanelConstraints.gridx = 1;
    leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    leftButtonPanelGridBagLayout.setConstraints(addToTreeSetLabel, leftButtonPanelConstraints);

    leftButtonPanelConstraints.gridx = 0;
    leftButtonPanelConstraints.gridwidth = 1;
    leftButtonPanelGridBagLayout.setConstraints(addToPriorityQueueButton, leftButtonPanelConstraints);
    leftButtonPanelConstraints.gridx = 1;
    leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    leftButtonPanelGridBagLayout.setConstraints(addToPriorityQueueLabel, leftButtonPanelConstraints);

    leftButtonPanelConstraints.gridx = 0;
    leftButtonPanelConstraints.gridwidth = 1;
    leftButtonPanelGridBagLayout.setConstraints(addToHashSetButton, leftButtonPanelConstraints);
    leftButtonPanelConstraints.gridx = 1;
    leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    leftButtonPanelGridBagLayout.setConstraints(addToHashSetLabel, leftButtonPanelConstraints);
    
		// create a panel to hold the right buttons
    javax.swing.JPanel rightButtonPanel = new javax.swing.JPanel();
    javax.swing.border.LineBorder rightButtonPanelLineBorder = new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 5);
    rightButtonPanel.setBorder(rightButtonPanelLineBorder);
    java.awt.GridBagLayout rightButtonPanelGridBagLayout = new java.awt.GridBagLayout();  
    rightButtonPanel.setLayout(rightButtonPanelGridBagLayout);
    java.awt.GridBagConstraints rightButtonPanelConstraints = new java.awt.GridBagConstraints();

    //Left buttons
    searchIntsButton = new javax.swing.JButton("search ints");
    searchIntsLabel = new javax.swing.JLabel("no result");
    searchBstButton = new javax.swing.JButton("search bst");
    searchBstLabel = new javax.swing.JLabel("no result");
    searchTreeSetButton= new javax.swing.JButton("search treeset");
    searchTreeSetLabel= new javax.swing.JLabel("no result");
    searchPriorityQueueButton = new javax.swing.JButton("search priority queue");
    searchPriorityQueueLabel = new javax.swing.JLabel("no result");
    searchHashSetButton = new javax.swing.JButton("search hashset");
    searchHashSetLabel = new javax.swing.JLabel("no result");

    //Left button constraints
    rightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
    rightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;

    rightButtonPanelConstraints.gridx = 0;
    rightButtonPanelConstraints.gridwidth = 1;
    rightButtonPanelConstraints.weightx = 1;
    rightButtonPanelGridBagLayout.setConstraints(searchIntsButton, rightButtonPanelConstraints);
    rightButtonPanelConstraints.gridx = 1;
    rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    rightButtonPanelGridBagLayout.setConstraints(searchIntsLabel, rightButtonPanelConstraints);

    rightButtonPanelConstraints.gridx = 0;
    rightButtonPanelConstraints.gridwidth = 1;
    rightButtonPanelGridBagLayout.setConstraints(searchBstButton, rightButtonPanelConstraints);
    rightButtonPanelConstraints.gridx = 1;
    rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    rightButtonPanelGridBagLayout.setConstraints(searchBstLabel, rightButtonPanelConstraints);

    rightButtonPanelConstraints.gridx = 0;
    rightButtonPanelConstraints.gridwidth = 1;
    rightButtonPanelGridBagLayout.setConstraints(searchTreeSetButton, rightButtonPanelConstraints);
    rightButtonPanelConstraints.gridx = 1;
    rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    rightButtonPanelGridBagLayout.setConstraints(searchTreeSetLabel, rightButtonPanelConstraints);

    rightButtonPanelConstraints.gridx = 0;
    rightButtonPanelConstraints.gridwidth = 1;
    rightButtonPanelGridBagLayout.setConstraints(searchPriorityQueueButton, rightButtonPanelConstraints);
    rightButtonPanelConstraints.gridx = 1;
    rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    rightButtonPanelGridBagLayout.setConstraints(searchPriorityQueueLabel, rightButtonPanelConstraints);

    rightButtonPanelConstraints.gridx = 0;
    rightButtonPanelConstraints.gridwidth = 1;
    rightButtonPanelGridBagLayout.setConstraints(searchHashSetButton, rightButtonPanelConstraints);
    rightButtonPanelConstraints.gridx = 1;
    rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    rightButtonPanelGridBagLayout.setConstraints(searchHashSetLabel, rightButtonPanelConstraints);

		
		// add the two panels to the main button panel
		buttonPanel.add(leftButtonPanel);
		buttonPanel.add(rightButtonPanel);
		
		// add the buttomns to the left panel
		leftButtonPanel.add(sortIntsButton);
    leftButtonPanel.add(sortIntsLabel);
    leftButtonPanel.add(addToBstButton);
    leftButtonPanel.add(addToBstLabel);
    leftButtonPanel.add(addToTreeSetButton);
    leftButtonPanel.add(addToTreeSetLabel);
    leftButtonPanel.add(addToPriorityQueueButton);
    leftButtonPanel.add(addToPriorityQueueLabel);
    leftButtonPanel.add(addToHashSetButton);
    leftButtonPanel.add(addToHashSetLabel);

    // add the buttomns to the right panel
		rightButtonPanel.add(searchIntsButton);
    rightButtonPanel.add(searchIntsLabel);
    rightButtonPanel.add(searchBstButton);
    rightButtonPanel.add(searchBstLabel);
    rightButtonPanel.add(searchTreeSetButton);
    rightButtonPanel.add(searchTreeSetLabel);
    rightButtonPanel.add(searchPriorityQueueButton);
    rightButtonPanel.add(searchPriorityQueueLabel);
    rightButtonPanel.add(searchHashSetButton);
    rightButtonPanel.add(searchHashSetLabel);

    //disable buttons
    sortIntsButton.setEnabled(false);
    addToBstButton.setEnabled(false);
    addToTreeSetButton.setEnabled(false);
    addToPriorityQueueButton.setEnabled(false);
    addToHashSetButton.setEnabled(false);

    searchIntsButton.setEnabled(false);
    searchBstButton.setEnabled(false);
    searchTreeSetButton.setEnabled(false);
    searchPriorityQueueButton.setEnabled(false);
    searchHashSetButton.setEnabled(false);

    // create the panel and add the buttons and menu bar
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
    mainPanel.setLayout(new java.awt.BorderLayout());
    mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
    mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
    mainPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);
    
    // create the action listeners for the menu items
		MenuItemActionListener readSortFileMenuItemActionListener = new MenuItemActionListener(readSortFile);
    MenuItemActionListener readSearchFileMenuItemActionListener = new MenuItemActionListener(readSearchFile);
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);

    // add the action listeners to the menu items
		readSortFile.addActionListener(readSortFileMenuItemActionListener);
		readSearchFile.addActionListener(readSearchFileMenuItemActionListener);
    fileExit.addActionListener(fileExitMenuItemActionListener);

    // create the action listeners for the buttons
    ButtonActionListener left1ButtonActionListener = new ButtonActionListener(sortIntsButton);
    ButtonActionListener left2ButtonActionListener = new ButtonActionListener(addToBstButton);
    ButtonActionListener left3ButtonActionListener = new ButtonActionListener(addToTreeSetButton);
    ButtonActionListener left4ButtonActionListener = new ButtonActionListener(addToPriorityQueueButton);
    ButtonActionListener left5ButtonActionListener = new ButtonActionListener(addToHashSetButton);

		ButtonActionListener right1ButtonActionListener = new ButtonActionListener(searchIntsButton);
    ButtonActionListener right2ButtonActionListener = new ButtonActionListener(searchBstButton);
    ButtonActionListener right3ButtonActionListener = new ButtonActionListener(searchTreeSetButton);
    ButtonActionListener right4ButtonActionListener = new ButtonActionListener(searchPriorityQueueButton);
    ButtonActionListener right5ButtonActionListener = new ButtonActionListener(searchHashSetButton);

    // add the action listeners to the buttons
		sortIntsButton.addActionListener(left1ButtonActionListener);
    addToBstButton.addActionListener(left2ButtonActionListener);
    addToTreeSetButton.addActionListener(left3ButtonActionListener);
    addToPriorityQueueButton.addActionListener(left4ButtonActionListener);
    addToHashSetButton.addActionListener(left5ButtonActionListener);

		searchIntsButton.addActionListener(right1ButtonActionListener);
    searchBstButton.addActionListener(right2ButtonActionListener);
    searchTreeSetButton.addActionListener(right3ButtonActionListener);
    searchPriorityQueueButton.addActionListener(right4ButtonActionListener);
    searchHashSetButton.addActionListener(right5ButtonActionListener);
    

    f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);

  }

  private static void selectionSort(){
    sortedValues = sortValues.clone();
    for(int i = 0; i < sortedValues.length-1; i++){
      for(int j = i+1; j < sortedValues.length; j++){
          if(sortedValues[j] < sortedValues[i]){
            int temp = sortedValues[j];
            sortedValues[j] = sortedValues[i];
            sortedValues[i] = temp;
          }
      }
    }
  }
  private static void searchInts(){
    int count = 0;
    for(int i = 0; i < searchValues.length; i++){

      int l = 0;
      int r = sortedValues.length - 1;
      while (l <= r) {
          int m = (r + l) / 2;
          if (sortedValues[m] == searchValues[i]){
            count++;
            break;
          }
          else if (sortedValues[m] < searchValues[i])
              l = m + 1;
          else
              r = m - 1;
      }
    }
    System.out.println("Binary Search Count: " + count);
  }

  private static void addToBinarySearchTree(){
    bst.setRoot(new Node(sortValues[0]));
    for(int i = 1; i < sortValues.length; i++){
      bst.insertNode(new Node(sortValues[i]));
    }
  }

  private static void searchBinarySearchTree(){
    int count = 0;
    for(int i = 0; i < searchValues.length; i++){
      if(bst.getNode(bst.getRoot(), searchValues[i])!= null){
        count++;
      }
    }
    System.out.println("Binary Search Tree Count: "+ count);
  }

  private static void addToTreeSet(){
    for(int i = 0; i < sortValues.length; i++){
    treeSetValues.add(sortValues[i]);
    }
  }
  private static void searchTreeSet(){
    int count = 0;
    for(int i = 0; i < searchValues.length; i++){
      if(treeSetValues.contains(searchValues[i])){
        count++;
      }
    }
    System.out.println("Search Tree Count: "+ count);
  }
  private static void addToPriorityQueue(){
    for(int i = 0; i<sortValues.length; i++){
      priorityQueueValues.add(sortValues[i]);
    }
  }
  private static void searchPriorityQueue(){
    int count = 0;
    for(int i = 0; i < searchValues.length; i++){
      if(priorityQueueValues.contains(searchValues[i])){
        count++;
      }
    }
    System.out.println("Priority Queue Search Count: "+ count);
  }
  private static void addToHashSet(){
    for(int i = 0; i<sortValues.length; i++){
      hashSetValues.add(sortValues[i]);
    }
  }
  private static void searchHashSet(){
    int count = 0;
    for(int i = 0; i < searchValues.length; i++){
      if(hashSetValues.contains(searchValues[i])){
        count++;
      };
    }
    System.out.println("Hash Set Count: "+ count);
  }

  private static void readData(String filename, boolean readSortValues){
    
    try{
      java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
      java.util.ArrayList<Integer> values = new java.util.ArrayList<>();
      String inn;
      while( (inn = input.readLine()) != null){
        StringTokenizer st = new StringTokenizer(inn, "\t");
        while (st.hasMoreTokens()) {
          values.add(Integer.parseInt(st.nextToken()));
        }
      }
      if(readSortValues){
        sortValues = new int[values.size()];
        for(int i = 0; i < sortValues.length; i++){
          sortValues[i] = values.get(i);
        }
      }
      else{
        searchValues = new int[values.size()];
        for(int i = 0; i < sortValues.length; i++){
          searchValues[i] = values.get(i);
        }
      }
      input.close();
    }
    catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
  }
	static class MenuItemActionListener implements java.awt.event.ActionListener{
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m)
		{
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + m.getText() + " menu item");
			
      if(m.getText().toLowerCase().equals("read sort file")){
        readData(sortFile,true);
        sortIntsButton.setEnabled(true);
        addToBstButton.setEnabled(true);
        addToTreeSetButton.setEnabled(true);
        addToPriorityQueueButton.setEnabled(true);
        addToHashSetButton.setEnabled(true);
      }
      if(m.getText().toLowerCase().equals("read search file")){
        readData(searchFile,false);
        enable_button = true;
        if(sortIntsLabel.getText() != "no result"){
          searchIntsButton.setEnabled(true);
        }
        if(addToBstLabel.getText() != "no result"){
          searchBstButton.setEnabled(true);
        }
        if(addToTreeSetLabel.getText() != "no result"){
          searchTreeSetButton.setEnabled(true);
        }
        if(addToPriorityQueueLabel.getText() != "no result"){
          searchPriorityQueueButton.setEnabled(true);
        }
        if(addToHashSetLabel.getText() != "no result"){
          searchHashSetButton.setEnabled(true);
        }
      }
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
		}
	}
	static class ButtonActionListener implements java.awt.event.ActionListener
	{
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b)
		{
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + b.getText() + " button");
      if(b.getText().toLowerCase().equals("sort ints")){
        long t0 = System.currentTimeMillis();
        selectionSort();
        long t1 = System.currentTimeMillis();
        sortIntsLabel.setText((t1-t0)+"ms");
        if(enable_button){
          searchIntsButton.setEnabled(true);
        }
      }
      if(b.getText().toLowerCase().equals("add to bst")){
        bst = new BinarySearchTree();
        long t0 = System.currentTimeMillis();
        addToBinarySearchTree();
        long t1 = System.currentTimeMillis();
        addToBstLabel.setText((t1-t0)+"ms");
        if(enable_button){
          searchBstButton.setEnabled(true);
        }
      }
      if(b.getText().toLowerCase().equals("add to treeset")){
        treeSetValues = new java.util.TreeSet<>();
        long t0 = System.currentTimeMillis();
        addToTreeSet();
        long t1 = System.currentTimeMillis();
        addToTreeSetLabel.setText((t1-t0)+"ms");
        if(enable_button){
          searchTreeSetButton.setEnabled(true);
        }
      }
      if(b.getText().toLowerCase().equals("add to priority queue")){
        priorityQueueValues = new java.util.PriorityQueue<>();
        long t0 = System.currentTimeMillis();
        addToPriorityQueue();
        long t1 = System.currentTimeMillis();
        addToPriorityQueueLabel.setText((t1-t0)+"ms");
        if(enable_button){
          searchPriorityQueueButton.setEnabled(true);
        }
      }
      if(b.getText().toLowerCase().equals("add to hashset")){
        hashSetValues = new java.util.HashSet<>();
        long t0 = System.currentTimeMillis();
        addToHashSet();
        long t1 = System.currentTimeMillis();
        addToHashSetLabel.setText((t1-t0)+"ms");
        if(enable_button){
          searchHashSetButton.setEnabled(true);
        }
      }
      if(b.getText().toLowerCase().equals("search ints")){
        long t0 = System.currentTimeMillis();
        searchInts();
        long t1 = System.currentTimeMillis();
        searchIntsLabel.setText((t1-t0)+"ms");
      }
      if(b.getText().toLowerCase().equals("search bst")){
        long t0 = System.currentTimeMillis();
        searchBinarySearchTree();
        long t1 = System.currentTimeMillis();
        searchBstLabel.setText((t1-t0)+"ms");
      }
      if(b.getText().toLowerCase().equals("search treeset")){
        long t0 = System.currentTimeMillis();
        searchTreeSet();
        long t1 = System.currentTimeMillis();
        searchTreeSetLabel.setText((t1-t0)+"ms");
      }
      if(b.getText().toLowerCase().equals("search priority queue")){
        long t0 = System.currentTimeMillis();
        searchPriorityQueue();
        long t1 = System.currentTimeMillis();
        searchPriorityQueueLabel.setText((t1-t0)+"ms");
      }
      if(b.getText().toLowerCase().equals("search hashset")){
        long t0 = System.currentTimeMillis();
        searchHashSet();
        long t1 = System.currentTimeMillis();
        searchHashSetLabel.setText((t1-t0)+"ms");
      }
      
		}
	}


}
