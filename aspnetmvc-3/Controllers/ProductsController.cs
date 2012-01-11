namespace mvcapp.Controllers
{
    using System.Collections.Generic;
    using System.Web.Mvc;

    using Models;

    public class ProductsController : Controller
    {
        #region Public Methods

        public ActionResult Index(int n)
        {
            List<Product> products = Service.GetProducts(n);
            return View(products);
        }

        #endregion
    }
}