import React, { useState } from 'react';
import { Form } from 'react-router-dom';

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
      <h2>Add Contact</h2>
      <form onSubmit={handleSubmit}>
        <label>
          First Name:
          <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} />
        </label>
        <br />
        <label>
          Last Name:
          <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} />
        </label>
        <br />
        <label>
          Email:
          <input type="email" name="email" value={formData.email} onChange={handleChange} />
        </label>
        <br />
        <label>
          Password:
          <input type="password" name="password" value={formData.password} onChange={handleChange} />
        </label>
        <br />
        <label>
          PAN:
          <input type="text" name="pan" value={formData.pan} onChange={handleChange} />
        </label>
        <br />
        <label>
          Phone:
          <input type="text" name="phone" value={formData.phone} onChange={handleChange} />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddContactComponent;
