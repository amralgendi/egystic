//
//  SystemData.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project;

import project.models.Admin;

import java.util.ArrayList;

public class AdminsData {
    private static ArrayList<Admin> admins = new ArrayList();

    private static Admin currentUser;

    public static void addNewAdmin(Admin admin) {
        admins.add(admin);
    }

    public static Admin login(String email, String password) {
        for (Admin admin: admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                currentUser = admin;
                return admin;
            }
        }

        return null;
    }

    public static Admin getCurrentUser() {
        return currentUser;
    }
}
