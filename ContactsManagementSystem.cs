using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        ContactsManager manager = new ContactsManager();
        while (true)
        {
            Console.WriteLine("\nContacts Management System");
            Console.WriteLine("1. Add Contact");
            Console.WriteLine("2. View Contacts");
            Console.WriteLine("3. Update Contact");
            Console.WriteLine("4. Delete Contact");
            Console.WriteLine("5. Exit");
            Console.Write("Choose an option: ");

            switch (Console.ReadLine())
            {
                case "1":
                    manager.AddContact();
                    break;
                case "2":
                    manager.ViewContacts();
                    break;
                case "3":
                    manager.UpdateContact();
                    break;
                case "4":
                    manager.DeleteContact();
                    break;
                case "5":
                    Console.WriteLine("Exiting...");
                    return;
                default:
                    Console.WriteLine("Invalid option, please try again.\n");
                    break;
            }
        }
    }
}


class Contact
{
    public string Name { get; set; }
    public string PhoneNumber { get; set; }
    public string Email { get; set; }
}

class ContactsManager
{
    private List<Contact> contacts = new List<Contact>();

    public void AddContact()
    {
        Console.Write("Enter Name: ");
        string name = Console.ReadLine();
        Console.Write("Enter Phone Number: ");
        string phoneNumber = Console.ReadLine();
        Console.Write("Enter Email: ");
        string email = Console.ReadLine();

        contacts.Add(new Contact { Name = name, PhoneNumber = phoneNumber, Email = email });
        Console.WriteLine("Contact added successfully!\n");
    }

    public void ViewContacts()
    {
        if (contacts.Count == 0)
        {
            Console.WriteLine("No contacts available.\n");
            return;
        }

        Console.WriteLine("Contacts List:");
        for (int i = 0; i < contacts.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {contacts[i].Name} - {contacts[i].PhoneNumber} - {contacts[i].Email}");
        }
        Console.WriteLine();
    }

    public void UpdateContact()
    {
        ViewContacts();
        Console.Write("Enter the number of the contact to update: ");
        if (int.TryParse(Console.ReadLine(), out int index) && index > 0 && index <= contacts.Count)
        {
            Console.Write("Enter New Name: ");
            contacts[index - 1].Name = Console.ReadLine();
            Console.Write("Enter New Phone Number: ");
            contacts[index - 1].PhoneNumber = Console.ReadLine();
            Console.Write("Enter New Email: ");
            contacts[index - 1].Email = Console.ReadLine();
            Console.WriteLine("Contact updated successfully!\n");
        }
        else
        {
            Console.WriteLine("Invalid selection.\n");
        }
    }

    public void DeleteContact()
    {
        ViewContacts();
        Console.Write("Enter the number of the contact to delete: ");
        if (int.TryParse(Console.ReadLine(), out int index) && index > 0 && index <= contacts.Count)
        {
            contacts.RemoveAt(index - 1);
            Console.WriteLine("Contact deleted successfully!\n");
        }
        else
        {
            Console.WriteLine("Invalid selection.\n");
        }
    }
}

