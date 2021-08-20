

<p style="text-align: center;">&nbsp;</p>
<p style="text-align: center;">&nbsp;</p>
<p align="center"><strong><img src="https://media.dhakatribune.com/uploads/2016/11/nsulogo.jpg" alt="" width="307" height="172" /></strong></p>
<p align="center"><strong>North South University</strong></p>
<p align="center">Department of Electrical &amp; Computer Engineering</p>
<p align="center"><strong>Theory Sub-Repository</strong></p>
<p align="center"><strong>SUMMER 2021 </strong></p>
<p align="center"><strong>Course Name</strong>: Mobile and Wireless Application Development </p>
<p align="center"><strong>Course No</strong>: CSE 486 <strong>Sec</strong><strong>:</strong> 01</p>
<p align="center"><strong>Faculty</strong>: Shaikh Shawon Arefin Shimon (SAS3)</p>
<p align="center"><strong><u>Member 1</u></strong><u>:</u></p>
<p align="center"><strong>Name</strong><strong>:</strong> H. M. Tamim</p>
<p align="center"><strong>ID</strong><strong>:&nbsp; </strong>1712305642</p>
<p align="center"><strong>Email</strong><strong>:</strong> <a href="mailto:hm.tamim@northsouth.edu">hm.tamim@northsouth.edu</a></p>
<p align="center"><strong>Git Repository</strong><strong>: </strong><a href="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/">https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/</a></p>
<p align="center"><strong>Date Prepared</strong><strong>: </strong>August 20, 2021</p>
<p><strong>&nbsp;</strong></p>
<p><strong>&nbsp;</strong></p>
--------------------------------------------------------------------------------------------
<h2>Overview</h2>


<p>
   In this assginment(quiz2), we were instructed to desgin and implement tab based edit prfoile flow.
<p></p>
<p>There are 2 new activities.</p>
<ul>
   <li>EditProfileActivity</li>
   <li>MembersActivity</li>
</ul>
<p>And 3 new fragments.</p>
<ul>
   <li>PersonalInformationTabFragment</li>
   <li>UniversitiesTabFragment</li>   
   <li>PhoneNumbersTabFragment</li>
</ul>
<p>And also 3 new bottom sheets.</p>
<ul>
   <li>EditPersonalInformationBottomSheet</li>
   <li>EditUniversityBottomSheet</li>   
   <li>EditPhoneNumberBottomSheet</li>
</ul>

<p></p>


<h2>Implementations</h2>

<p>To make the codebase clean and easily managable, MVVM design pattern were followed. Besides that, BaseFragment, BaseActivity, BaseBottomSheetFragment were written to reduce code boilerplates, and automate databinding, viewmodel. </p>

<p>The tab based UI was implemented via ViewPager2 and FragmentStateAdapter. The fragments were added in the ViewPager adapter. TabLayoutMediator was used to connect TabLayout and ViewPager.</p>

<p>Sperate bottom sheets were designed and implemented to insert or edit personal information, universities and phone numbers. To communicate BottomSheet to Fragment, a shared activity instance ViewModel and MutableLiveData were used. When data is inserted from bottom sheet, that common LiveData was tiggered which was observed in fragment to update user data. Then that data were used populate the RecyclerView of University List, Phone Number List.</p>

<p>After entering all the data with step by step validation with toasts message, user can click on save button in toolbar. Which will open MembersActivity with the user details serializable model intent. On the MembersActivity, that serializable model was stored.</p>


<p>To save the data in phone, SharedPreference was used. But the challenge was, shared perference don't allow us to save list. To solve that issue, GSON were used to convert the list to a JSON structured string and then saved to SharedPreference as string. When the list was needed, it was simply parsed via GSON to UserDetailsModel object again.</p>



<p></p>
<h2>Screenshots</h2>
<table>
   <tr>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234228.jpg?raw=true"/>
      </td>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234245.jpg?raw=true"/>
      </td>
   </tr>
   <tr>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234247.jpg?raw=true"/>
      </td>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234252.jpg?raw=true"/>
      </td>
   </tr>
   <tr>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234312.jpg?raw=true"/>
      </td>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234317.jpg?raw=true"/>
      </td>
   </tr>
   <tr>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234413.jpg?raw=true"/>
   </td>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234426.jpg?raw=true"/>
      </td>
   </tr>
   <tr>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/Screenshot_20210820-234621.jpg?raw=true"/>
      </td>
      <td>
         <img src="https://github.com/NSU-SU21-CSE486-1/1712305_SU21_CSE486_1/blob/main/Theory/Assignment/Assignment02/Screenshots/screenshot_20210820-234350.jpg?raw=true"/>
      </td>
   </tr>
  
</table>

