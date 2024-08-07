// 3) Create Statement
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No for which you have to Update Name and Age");
        int askrno = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Updated Name ");
        String updnmame = sc.nextLine();

        System.out.println("Enter Updated Age ");
        int updage = sc.nextInt();

        Statement st = con.createStatement();
        String sql = "UPDATE student_detail SET name = '" + updnmame + "', age = " + updage + " WHERE roll_no = "
                + askrno;
        int r = st.executeUpdate(sql);
