using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formulario
{
    public partial class Formulario : Form
    {
        protected double dato = 0;
        protected double res = 0;
        public Formulario()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void buttonConvert_Click(object sender, EventArgs e)
        {
            dato = Convert.ToDouble(txtEntrada.Text);

            if (ListOpcion.SelectedItem.Equals("°C a °F"))
            {
                res = ((dato * 1.8) + 32.2);
                txtSalida.Text = res.ToString();

            }else if (ListOpcion.SelectedItem.Equals("°C a °K"))
            {
                res = (dato + 273.15);
                txtSalida.Text = res.ToString();
                
            }
            else if (ListOpcion.SelectedItem.Equals("°F a °C"))
            {
                res = ((dato - 32) * 5 / 9);
                txtSalida.Text = res.ToString();

            }
            else if (ListOpcion.SelectedItem.Equals("°F a °K"))
            {
                res = ((dato - 32) * 5 / 9) + 273.15;
                txtSalida.Text = res.ToString();

            }
            else if (ListOpcion.SelectedItem.Equals("°K a °C"))
            {
                res = dato - 273.15;
                txtSalida.Text = res.ToString();
            }
            else if (ListOpcion.SelectedItem.Equals("°K a °F"))
            {
                res = ((dato - 273.15) * 9 / 5) + 32;
                txtSalida.Text = res.ToString();
            }
            
            
        }

        private void label1_Click_1(object sender, EventArgs e)
        {
            txtEntrada.Text = " ";
            txtSalida.Text = " ";
        }

        private void buttonLimpiar_Click(object sender, EventArgs e)
        {

        }
    }
}
