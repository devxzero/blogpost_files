namespace mvcapp.Models
{
    using System.Collections.Generic;

    public class Service
    {
        #region Constants and Fields

        private static readonly List<Category> categories = new List<Category>();

        private static readonly List<Product> products = new List<Product>();

        #endregion

        #region Constructors and Destructors

        static Service()
        {
            for (var i = 0; i < 5; i++)
            {
                string name = (1000 + i).ToString();
                categories.Add(new Category(name));
            }

            for (var i = 0; i < 20000; i++)
            {
                string name = i.ToString();
                string description = (i * i).ToString();

                var product = new Product(name, i, description);

                product.Categories.AddRange(categories);
                products.Add(product);
            }
        }

        #endregion

        #region Public Methods

        public static List<Product> GetProducts(int max)
        {
            return products.GetRange(0, max);
        }

        #endregion
    }
}