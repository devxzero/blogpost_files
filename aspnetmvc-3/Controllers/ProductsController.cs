namespace mvcapp.Controllers
{
    using System.Web.Mvc;

    using Models;

    public class ProductsController : Controller
    {
        #region Public Methods

        public ActionResult Index(int n)
        {            
            var products = Service.GetProducts(n);
            return View(products);
        }

        #endregion
    }
}