import React, { useState } from 'react';
import { Route, Routes, Link, BrowserRouter } from 'react-router-dom';

const DashboardComponent = () => <div>DashBoard component</div>;
const AddContactComponent = () => {
    const [formData, setFormData] = useState({
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      pan: '',
      phone: '',
    });
  
    const handleChange = (e) => {
      const { name, value } = e.target;
      setFormData((prevData) => ({
        ...prevData,
        [name]: value,
      }));
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      // Add logic to handle form submission
      console.log('Form submitted:', formData);
      // You can add logic here to send the form data to the server or perform other actions
    };
  
    return (
      <div>
        <h2>Customer Registration</h2>
        <form onSubmit={handleSubmit}>
          <label>
            First Name:
            <input type="text" name="firstName" className='form-control' value={formData.firstName} onChange={handleChange} />
          </label>
          <br />
          <label>
            Last Name:
            <input type="text" name="lastName" className='form-control'value={formData.lastName} onChange={handleChange} />
          </label>
          <br />
          <label>
            Email:
            <input type="email" name="email"className='form-control' value={formData.email} onChange={handleChange} />
          </label>
          <br />
          <label>
            Password:
            <input type="password" name="password"className='form-control' value={formData.password} onChange={handleChange} />
          </label>
          <br />
          <label>
            PAN:
            <input type="text" name="pan"className='form-control' value={formData.pan} onChange={handleChange} />
          </label>
          <br />
          <label>
            Phone:
            <input type="text" name="phone"className='form-control' value={formData.phone} onChange={handleChange} />
          </label>
          <br />
          <button type="submit" className='btn btn-primary'>Submit</button>
        </form>
      </div>
    );
  };
const ListContactsComponent = () => <div>List Contact component</div>;

const CustomerComponent = () => {
  return (
    <BrowserRouter>
      <div className='container'>
        <Link to='/login'>Login</Link>&nbsp;&nbsp;
        <Link to='/registraion'>Registraion</Link>&nbsp;&nbsp;
        <Link to='/listContacts'>Show All Contacts</Link>&nbsp;&nbsp;
        <Link to='/editprofile'>Edit Profile</Link>&nbsp;&nbsp;

        <Routes>
          <Route path='/' element={<DashboardComponent />} />
          <Route path='/dashboard' element={<DashboardComponent />} />
          <Route path='/registraion' element={<AddContactComponent />} />
          <Route path='/listContacts' element={<ListContactsComponent />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default CustomerComponent;
