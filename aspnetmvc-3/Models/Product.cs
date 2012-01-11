namespace mvcapp.Models
{
    using System.Collections.Generic;
    using System.Linq;

    public class Product
    {
        #region Constructors and Destructors

        public Product(string name, int price, string description, params Category[] categories)
        {
            this.Name = name;
            this.Price = price;
            this.Description = description;
            this.Categories = categories.ToList();
        }

        #endregion

        #region Public Properties

        public List<Category> Categories { get; set; }

        public string Description { get; set; }

        public string Name { get; set; }

        public int Price { get; set; }

        #endregion
    }
}