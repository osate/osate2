package fr.tpt.aadl.annex.behavior.wizards;

import java.io.File ;
import java.io.FileFilter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.Collection ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.core.runtime.IPath ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.MultiStatus ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.jface.dialogs.ErrorDialog ;
import org.eclipse.jface.layout.TreeColumnLayout ;
import org.eclipse.jface.viewers.ColumnWeightData ;
import org.eclipse.jface.viewers.DoubleClickEvent ;
import org.eclipse.jface.viewers.IDoubleClickListener ;
import org.eclipse.jface.viewers.IStructuredSelection ;
import org.eclipse.jface.viewers.ITreeContentProvider ;
import org.eclipse.jface.viewers.LabelProvider ;
import org.eclipse.jface.viewers.TreeViewer ;
import org.eclipse.jface.viewers.Viewer ;
import org.eclipse.jface.viewers.ViewerSorter ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.graphics.Image ;
import org.eclipse.swt.layout.GridData ;
import org.eclipse.swt.layout.GridLayout ;
import org.eclipse.swt.widgets.Composite ;
import org.eclipse.swt.widgets.Display ;
import org.eclipse.swt.widgets.Label ;
import org.eclipse.swt.widgets.Tree ;
import org.eclipse.swt.widgets.TreeColumn ;
import org.osate.ui.wizards.AadlProjectWizard ;
import org.osate.workspace.WorkspacePlugin ;

import com.google.common.io.Files ;

import fr.tpt.aadl.annex.behavior.utils.AadlBaNames ;
import fr.tpt.aadl.utils.Aadl2Utils ;

public class AadlBaExamplesWizard extends AadlProjectWizard
{
  protected final static String _EXAMPLE_ROOT_PATH = "examples" ;
  protected final static String _ADD_IMG_FILE_PATH = "resources/img/file_add_16.png" ;
  protected final static String _REMOVE_IMG_FILE_PATH = "resources/img/file_remove_16.png" ;
  protected final static String _CAT_IMG_FILE_PATH = "resources/img/folder_16.png" ;
  
  protected Map<String, List<Integer>> _SelectedExamplesTreeContent = 
                                          new HashMap<String, List<Integer>>() ;
  
  protected List<File> _files = new ArrayList<File>() ;
  
  public class AadlBaExamplesWizardPage extends WizardNewAadlProjectCreationPage
  {
    // Gives the category for a given file index.
    protected List<String> _fileMapping = new ArrayList<String>() ;
    
    public class TreeContentProvider implements ITreeContentProvider
    {
      Map<String, List<Integer>> _treeContent ; 
      
      public void dispose()
      {
        // Nothing to do.
      }

      @SuppressWarnings("unchecked")
      @Override
      public void inputChanged(Viewer viewer,
                               Object oldInput,
                               Object newInput)
      {
        _treeContent = (Map<String, List<Integer>>) newInput ;
      }

      @Override
      public Object[] getElements(Object inputElement)
      {
        if(inputElement != null)
        {
          return _treeContent.keySet().toArray() ;
        }
        else
        {
          return null ;
        }
      }

      @Override
      public Object[] getChildren(Object parentElement)
      {
        if(parentElement instanceof String)
        {
          return _treeContent.get(parentElement).toArray() ;
        }
        else
        {
          return null ;
        }
      }

      @SuppressWarnings("unchecked")
      @Override
      public Object getParent(Object element)
      {
        if(element instanceof String)
        {
          return null ;
        }
        else if(element instanceof ArrayList)
        {
          element = ((ArrayList<Integer>) element).get(0) ;
        }
        
        return _fileMapping.get((Integer) element) ;
      }

      @Override
      public boolean hasChildren(Object element)
      {
        return element instanceof String ;
      }
    }
    
    public class FileLabelProvider extends LabelProvider
    {
      private Image _fileImg ;
      private Image _catImg ;

      public FileLabelProvider(Image fileImg, Image categoryImg)
      {
        super () ;
        _fileImg = fileImg ;
        _catImg = categoryImg ;
      }
      
      @Override
      public Image getImage(Object element)
      {
        if(element instanceof Integer)        
        {
          return _fileImg ;
        }
        else
        {
          return _catImg ;
        }
      }

      @Override
      public void dispose()
      {
        if (_fileImg != null)
        {
          _fileImg.dispose() ;
        }
        
        if(_catImg != null)
        {
          _catImg.dispose() ;
        }
        
        super.dispose() ;
      }

      @Override
      public String getText(Object element)
      {
        if(element instanceof Integer)
        {
          File file = _files.get((Integer) element) ;
          String result = file.getName() ;
          int i = result.indexOf('.') ;
          if (i > 0)
          {
            return result.substring(0,i) ;
          }
          else
          {
            return result ;
          }
        }
        else
        {
          return element.toString() ;
        }
      }
    }

    public AadlBaExamplesWizardPage(String pageId)
    {
      super(pageId) ;
    }
    
    @Override
    public void createControl(Composite parent)
    {
      super.createControl(parent);
      
      // Creates examples choice panel.
      
      Composite inheritePanel = (Composite) super.getControl() ;
      Composite panelChoice = new Composite(inheritePanel, SWT.NULL); 
      
      GridLayout layout = new GridLayout();
      layout.numColumns = 2 ;
      
      panelChoice.setLayout(layout);
      panelChoice.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
      panelChoice.setFont(inheritePanel.getFont()) ;
      
      Label labelLeft = new Label(panelChoice, SWT.LEFT);
      labelLeft.setText("Available examples:") ;
      labelLeft.setFont(inheritePanel.getFont()) ;
      
      Label labelRight = new Label(panelChoice, SWT.LEFT);
      labelRight.setText("Examples selected:") ;
      labelRight.setFont(inheritePanel.getFont()) ;
      
      final TreeViewer pickTree = this.createTree(panelChoice) ;
      final TreeViewer selectionTree = this.createTree(panelChoice) ;
      
      pickTree.setSorter(new ViewerSorter()) ;
      selectionTree.setSorter(new ViewerSorter()) ;
      
      pickTree.addDoubleClickListener(new IDoubleClickListener()
      {
        @Override
        public void doubleClick(DoubleClickEvent event)
        {
          swap(pickTree, selectionTree, event) ;
        }
      }) ;
      
      selectionTree.addDoubleClickListener(new IDoubleClickListener()
      {
        @Override
        public void doubleClick(DoubleClickEvent event)
        {
          swap(selectionTree, pickTree, event) ;
        }
      }) ;
      
      Image imgRemove = null ;
      Image imgAdd = null ;
      Image categoryImg = null ;
      
      try
      { 
        Display disp = panelChoice.getDisplay() ;
        
        imgRemove = getImage(disp, _REMOVE_IMG_FILE_PATH) ;
        imgAdd = getImage(disp, _ADD_IMG_FILE_PATH) ;
        categoryImg = getImage(disp, _CAT_IMG_FILE_PATH) ;
      }
      catch (Exception e)
      {
        // Nothing to do: image will be null.
        System.err.println("at least one of the example images is not found") ;
      }
      
      pickTree.setLabelProvider(new FileLabelProvider(imgAdd, categoryImg)) ;
      
      selectionTree.setLabelProvider(new FileLabelProvider(imgRemove, categoryImg)) ;
      initTreeViewer(selectionTree, _SelectedExamplesTreeContent) ;
      
      try
      {
         initTreeViewer(pickTree, loadExamples(_EXAMPLE_ROOT_PATH)) ;
      }
      catch(Exception e)
      {
        reportError("examples not found",e) ;
      }
      
      this.setControl(inheritePanel) ;
    }
    
    protected Image getImage(Display disp, String relativePathToImage) throws Exception
    {
      Image result = null ;
      
      String absolutPath = Aadl2Utils.getPluginFile(AadlBaNames.PLUGIN_ID,
                                                    relativePathToImage).
                                                       toString() ;
      result = new Image(disp, absolutPath) ;
      return result ;
    }
    
    @SuppressWarnings("unchecked")
    protected void swap(TreeViewer fromViewer, TreeViewer toViewer,
                        DoubleClickEvent node)
    {
      IStructuredSelection selected = (IStructuredSelection)node.getSelection() ;
      Object selectedNode = selected.getFirstElement() ;
      Map<String, List<Integer>> fromModel = (Map<String, List<Integer>>) fromViewer.getInput() ;
      Map<String, List<Integer>> toModel = (Map<String, List<Integer>>) toViewer.getInput() ;
      
      String cat ;
      
      if(selectedNode instanceof String)
      {
        cat = (String) selectedNode ;
        List<Integer> fromFileIndexes = fromModel.get(cat) ;
        
        if(! fromFileIndexes.isEmpty())
        {
          List<Integer> toFileIndexes = toModel.get(cat) ;
                    
          if(toFileIndexes == null)
          {
            toModel.put(cat, fromFileIndexes) ;
          }
          else
          {
            toFileIndexes.addAll(fromFileIndexes) ;
          }
        }
        
        fromModel.remove(cat) ;
      }
      else
      {
        Integer index = (Integer) selectedNode ;
        cat = _fileMapping.get(index) ;
        List<Integer> fromFileIndexes = fromModel.get(cat) ; 
        List<Integer> toFileIndexes = toModel.get(cat) ;
        
        if(toFileIndexes == null)
        {
          toFileIndexes = new ArrayList<Integer>(fromFileIndexes.size()) ;
          toModel.put(cat, toFileIndexes) ;
        }
        
        toFileIndexes.add(index) ;
        fromFileIndexes.remove(index) ;
      }
      
      fromViewer.refresh() ;
      toViewer.refresh() ;
      toViewer.expandToLevel(cat, 2) ;
    }
    
    protected void initTreeViewer(TreeViewer viewer, Map<String, List<Integer>>
                                  treeContent)
    {
      viewer.setContentProvider(new TreeContentProvider());
      viewer.setInput(treeContent) ;
    }
    
    protected Map<String, List<Integer>> loadExamples(String examplesPath) 
                                                                throws Exception
    {
      File rootPath = Aadl2Utils.getPluginFile(AadlBaNames.PLUGIN_ID,
                                               examplesPath) ;
      if (rootPath.isDirectory())
      {
        Map<String, List<Integer>> treeContent = new HashMap<String, List<Integer>>();
        int count = 0 ;
        
        for(File f : rootPath.listFiles())
        {
          if (f.isDirectory())
          {
            String key = f.getName() ;
            key = key.replaceAll("_", " ") ;
            
            File[] files = f.listFiles(new FileFilter()
            {
              @Override
              public boolean accept(File pathname)
              {
                String fileName = pathname.getName() ;
                
                int i = fileName.lastIndexOf('.') ;
                
                String extension = fileName.substring(i+1, fileName.length()) ;
                
                return WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(extension) ||
                       WorkspacePlugin.SOURCE_FILE_EXT2.equalsIgnoreCase(extension) ;
              }
            }) ;
            
            if(files.length > 0)
            {
              List<Integer> index = new ArrayList<Integer>(files.length) ;
              
              for(int i = 0 ; i < files.length ; i++)
              {
                index.add(count) ;
                _fileMapping.add(key) ;
                _files.add(files[i]) ;
                count++ ;
              }
              
              treeContent.put(key, index) ;
            }
            else
            {
              continue ;
            }
          }
          else
          {
            continue ;
          }
        }
        
        return treeContent ;
      }
      else
      {
        throw new Exception(examplesPath + " is not directory") ;
      }
    }
    
    protected TreeViewer createTree(Composite parent)
    {
      GridData compLayout = new GridData(GridData.FILL_BOTH) ;
      compLayout.heightHint = 200 ;
      compLayout.widthHint = 200 ;
      
      Composite treeComposite = new Composite(parent, SWT.NONE) ;
      treeComposite.setLayoutData(compLayout);
      
      GridData dataLayout = new GridData(GridData.FILL_BOTH) ;
      dataLayout.heightHint = compLayout.heightHint ;
      dataLayout.widthHint = compLayout.widthHint ;
      
      int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL ;
      Tree tree = new Tree(treeComposite, style) ;
      tree.setLayoutData(dataLayout) ;
      tree.setLinesVisible(true) ;
      tree.setHeaderVisible(false) ;
      tree.setFont(parent.getFont()) ;
      
      TreeColumn col = new TreeColumn (tree, SWT.LEFT);
      
      TreeColumnLayout treeLayout = new TreeColumnLayout() ;
      treeLayout.setColumnData(col, new ColumnWeightData(dataLayout.widthHint)) ;
      treeComposite.setLayout(treeLayout) ;

      return new TreeViewer(tree) ;
    }
  }
  
  @Override
  public void addPages()
  {
    newProjectCreationPage = new AadlBaExamplesWizardPage("basicNewProjectPage");
    newProjectCreationPage.setTitle("Aadl Behavior Annex Project");
    newProjectCreationPage.setDescription("Create a new Aadl Behaviort Annex project resource.");
    this.addPage(newProjectCreationPage);
    
    referencePage = new AADLWizardReferencePage("projectReferencePage");
    referencePage.setTitle("AADL Settings");
    referencePage.setDescription("Define the AADL Settings");

    this.addPage(referencePage);
  }

  @Override
  public boolean performFinish()
  {
    boolean result = super.performFinish() ;
    
    if(result)
    {
      try
      {
        List<File> selectedExamples =
                      this.fetchSelectedExampels(_SelectedExamplesTreeContent) ;
        if(!selectedExamples.isEmpty())
        {
          IPath projectPath = this.newProject.getLocation() ;

          File destFolder =
                new File(projectPath.toString() + IPath.SEPARATOR +
                      _EXAMPLE_ROOT_PATH) ;
          destFolder.mkdir() ;

          copyFiles(selectedExamples, destFolder) ;
          
          this.newProject.refreshLocal(2, null) ;
        }
      }
      catch (Exception e)
      {
        result = false ;
        reportError("Save examples problem", e) ;
      }
    }
    
    return result ;
  }
  
  protected void reportError(String title, Exception e)
  {
    MultiStatus details = new MultiStatus(AadlBaNames.PLUGIN_ID,
                                          1,
                                          e.getMessage(),
                                          e);
    
    StackTraceElement[] traces = e.getStackTrace() ;
    
    if(traces.length > 0)
    {
      for(StackTraceElement t : traces)
      {
        details.add(new Status(IStatus.ERROR, AadlBaNames.PLUGIN_ID, t.toString())) ;
      }
    }
    
    ErrorDialog.openError(getShell(), title, title, details) ;
    
  }
  
  protected List<File> fetchSelectedExampels(Map<String,
                                             List<Integer>> treeContent)
  {
    Collection<List<Integer>> content = treeContent.values() ;
    List<File> result = new ArrayList<File>() ;
    
    for(List<Integer> fileIndexes : content)
    {
      for(Integer index : fileIndexes)
      {
        result.add(_files.get(index)) ;
      }
    }
    
    return result ;
  }
  
  protected void copyFiles(List<File> files, File destFolder) throws IOException
  {
    File newFile = null ;
    
    for(File f : files)
    {
      newFile = new File(destFolder.getPath() + File.separatorChar + 
                         f.getName()) ;
      Files.copy(f, newFile) ;
    }
  }
}