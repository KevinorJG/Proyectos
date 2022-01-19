
namespace Formulario
{
    partial class Formulario
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.ListOpcion = new System.Windows.Forms.ComboBox();
            this.buttonConvert = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.txtEntrada = new System.Windows.Forms.TextBox();
            this.Label = new System.Windows.Forms.Label();
            this.txtSalida = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.buttonLimpiar = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // ListOpcion
            // 
            this.ListOpcion.CausesValidation = false;
            this.ListOpcion.DisplayMember = "1";
            this.ListOpcion.FormattingEnabled = true;
            this.ListOpcion.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.ListOpcion.Items.AddRange(new object[] {
            "°C a °F",
            "°C a °K",
            "°F a °C",
            "°F a °K",
            "°K a °C",
            "°K a °F"});
            this.ListOpcion.Location = new System.Drawing.Point(143, 179);
            this.ListOpcion.Name = "ListOpcion";
            this.ListOpcion.Size = new System.Drawing.Size(121, 21);
            this.ListOpcion.TabIndex = 1;
            // 
            // buttonConvert
            // 
            this.buttonConvert.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.buttonConvert.Location = new System.Drawing.Point(86, 150);
            this.buttonConvert.Name = "buttonConvert";
            this.buttonConvert.Size = new System.Drawing.Size(85, 23);
            this.buttonConvert.TabIndex = 2;
            this.buttonConvert.Text = "CONVERTIR";
            this.buttonConvert.UseVisualStyleBackColor = true;
            this.buttonConvert.Click += new System.EventHandler(this.buttonConvert_Click);
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.buttonLimpiar);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.Label);
            this.panel1.Controls.Add(this.txtSalida);
            this.panel1.Controls.Add(this.txtEntrada);
            this.panel1.Controls.Add(this.ListOpcion);
            this.panel1.Controls.Add(this.buttonConvert);
            this.panel1.Location = new System.Drawing.Point(5, 3);
            this.panel1.Margin = new System.Windows.Forms.Padding(0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(396, 281);
            this.panel1.TabIndex = 5;
            this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // txtEntrada
            // 
            this.txtEntrada.Location = new System.Drawing.Point(60, 105);
            this.txtEntrada.Name = "txtEntrada";
            this.txtEntrada.Size = new System.Drawing.Size(100, 20);
            this.txtEntrada.TabIndex = 4;
            // 
            // Label
            // 
            this.Label.AutoSize = true;
            this.Label.Location = new System.Drawing.Point(10, 108);
            this.Label.Name = "Label";
            this.Label.Size = new System.Drawing.Size(47, 13);
            this.Label.TabIndex = 6;
            this.Label.Text = "Entrada:";
            this.Label.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // txtSalida
            // 
            this.txtSalida.Location = new System.Drawing.Point(257, 105);
            this.txtSalida.Name = "txtSalida";
            this.txtSalida.Size = new System.Drawing.Size(100, 20);
            this.txtSalida.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(204, 108);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(39, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Salida:";
            // 
            // buttonLimpiar
            // 
            this.buttonLimpiar.Location = new System.Drawing.Point(257, 150);
            this.buttonLimpiar.Name = "buttonLimpiar";
            this.buttonLimpiar.Size = new System.Drawing.Size(75, 23);
            this.buttonLimpiar.TabIndex = 8;
            this.buttonLimpiar.Text = "Limpiar";
            this.buttonLimpiar.UseVisualStyleBackColor = true;
            this.buttonLimpiar.Click += new System.EventHandler(this.buttonLimpiar_Click);
            // 
            // Formulario
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(408, 285);
            this.Controls.Add(this.panel1);
            this.MaximizeBox = false;
            this.Name = "Formulario";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.Text = "Conversor";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ComboBox ListOpcion;
        private System.Windows.Forms.Button buttonConvert;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label Label;
        private System.Windows.Forms.TextBox txtEntrada;
        private System.Windows.Forms.TextBox txtSalida;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonLimpiar;
    }
}

