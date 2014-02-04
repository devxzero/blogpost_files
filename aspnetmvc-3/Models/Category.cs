namespace mvcapp.Models
{
    public class Category
    {
        #region Constructors and Destructors

        public Category(string name)
        {
            this.Name = name;
        }

        #endregion

        #region Public Properties

        public string Name { get; private set; }

        #endregion
    }
}